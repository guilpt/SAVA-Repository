package com.vitaanimale.sava.controller;

import com.vitaanimale.sava.business.IProdutosBO;
import com.vitaanimale.sava.infra.SavaBusinessException;
import com.vitaanimale.sava.to.ItensProdutos;
import com.vitaanimale.sava.to.Produtos;
import com.vitaanimale.sava.to.TiposProdutos;
import java.io.Serializable;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Elisa
 */
@Controller
@ManagedBean
@ViewScoped
public class ItensProdutosController extends SAVAAbstractController implements Serializable {
    
    private static final long serialVersionUID = 1741168426757323414L;
    
    @ManagedProperty("#{produtosBO}")
    @Autowired
    private IProdutosBO produtosBO;
    
    private Integer idItemProduto;
    private Integer idTipoProduto;
    private Integer idProduto;
    private String  codBarra;
    private Double  valorCompraProduto;
    private Double  valorVendaProduto;
    private String  dataEntrada;
    private String  dataValidade;
    
    private List<TiposProdutos> listaTiposProdutos;
    private List<Produtos> listaProdutos;
    private Produtos produto;

    public IProdutosBO getProdutosBO() {
        return produtosBO;
    }

    public void setProdutosBO(IProdutosBO produtosBO) {
        this.produtosBO = produtosBO;
    }

    public Integer getIdItemProduto() {
        return idItemProduto;
    }

    public void setIdItemProduto(Integer idItemProduto) {
        this.idItemProduto = idItemProduto;
    }

    public Integer getIdTipoProduto() {
        return idTipoProduto;
    }

    public void setIdTipoProduto(Integer idTipoProduto) {
        this.idTipoProduto = idTipoProduto;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    public Double getValorCompraProduto() {
        return valorCompraProduto;
    }

    public void setValorCompraProduto(Double valorCompraProduto) {
        this.valorCompraProduto = valorCompraProduto;
    }

    public Double getValorVendaProduto() {
        return valorVendaProduto;
    }

    public void setValorVendaProduto(Double valorVendaProduto) {
        this.valorVendaProduto = valorVendaProduto;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public List<TiposProdutos> getListaTiposProdutos() {
        return listaTiposProdutos;
    }

    public void setListaTiposProdutos(List<TiposProdutos> listaTiposProdutos) {
        this.listaTiposProdutos = listaTiposProdutos;
    }

    public List<Produtos> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produtos> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }
    
    public Collection<SelectItem> getCollectionTiposProdutos() {
        Collection<SelectItem> collectionTiposProdutos = new ArrayList<>();
        collectionTiposProdutos.add(new SelectItem(-1, "Selecione..."));
        for (TiposProdutos tipoProduto : this.listaTiposProdutos) {
            collectionTiposProdutos.add(new SelectItem(tipoProduto.getIdTipoProduto(), tipoProduto.getDescricaoTipoProduto()));
        }

        return collectionTiposProdutos;
    }

    public Collection<SelectItem> getCollectionProdutos() {
        Collection<SelectItem> collectionProdutos = new ArrayList<>();
        collectionProdutos.add(new SelectItem(-1, "Selecione..."));
        if (this.listaProdutos != null) {
            for (Produtos produto : this.listaProdutos) {
                collectionProdutos.add(new SelectItem(produto.getIdProduto(), produto.getDescricaoProduto()));
            }
        }

        return collectionProdutos;
    }
    
    public String init() {
        FacesContext initItensProdutoscontext = FacesContext.getCurrentInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataAtual = new Date();

        try {
            this.idItemProduto = null;
            this.idTipoProduto = null;
            this.idProduto = null;
            this.codBarra = "";
            this.valorCompraProduto = null;
            this.valorVendaProduto = null;
            this.dataEntrada = sdf.format(dataAtual);
            this.dataValidade = "";
            
            this.listaTiposProdutos = produtosBO.buscarTiposProdutos();
            this.listaProdutos = new ArrayList<>();
        } catch (SavaBusinessException e) {
            initItensProdutoscontext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "NÃ£o foi possÃ­vel buscar a lista de tipos de produtos!"));
        }

        this.controlarExibicao(false, true);

        return "/pages/cadastro/itensProdutos?faces-redirect=true";
    }
    
    public String novo() {
        FacesContext novoItemProdutoContext = FacesContext.getCurrentInstance();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataAtual = new Date();
        
        this.idTipoProduto = -1;
        this.idProduto = -1;
        this.valorCompraProduto = null;
        this.valorVendaProduto = null;
        this.dataEntrada = sdf.format(dataAtual);
        this.dataValidade = "";
        this.codBarra = "";
        
        return ACTION_INPUT;
    }
    
    public String buscarProdutosPorIdTipoProduto() {
        FacesContext buscarProdutosPorIdTipoProdutoContext = FacesContext.getCurrentInstance();

        try {
            this.listaProdutos = produtosBO.buscarProdutosPorIdTipoProduto(this.idTipoProduto);
        } catch (SavaBusinessException e) {
            buscarProdutosPorIdTipoProdutoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "NÃ£o foi possÃ­vel buscar os produtos!"));
        }

        return ACTION_INPUT;
    }
    
    public String buscarInformacaoProduto() {
        FacesContext buscarInformacaoProdutoContext = FacesContext.getCurrentInstance();

        try {
            this.produto = produtosBO.buscarInformacaoProduto(this.idProduto);
            this.valorCompraProduto = this.produto.getValorCompraProduto();
            this.valorVendaProduto = this.produto.getValorVendaProduto();
        } catch (SavaBusinessException e) {
            buscarInformacaoProdutoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "NÃ£o foi possÃ­vel buscar a informação do produto!"));
        }

        return ACTION_INPUT;
    }
    
    public String inserirItemProduto() {
        FacesContext inserirItemProdutoContext = FacesContext.getCurrentInstance();
        Integer linhasAfetadas = 0;

        if (this.validaDados()) {
            ItensProdutos itemProduto = new ItensProdutos(null, this.idProduto, this.codBarra, this.valorCompraProduto, this.valorVendaProduto, this.dataEntrada, null, this.dataValidade, null);

            try {
                linhasAfetadas = produtosBO.inserirItemProduto(itemProduto);
                
                if (linhasAfetadas == 1) {
                    inserirItemProdutoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info:", "Item inserido com sucesso!"));
                }
            } catch (SavaBusinessException e) {
                inserirItemProdutoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "NÃ£o foi possÃ­vel inserir o item!"));
            }
        } else {
            inserirItemProdutoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", this.getMensagemValidacao()));
        }
        
        return ACTION_INPUT;
    }
    
    public Boolean validaDados() {
        Boolean resultado = true;

        if (this.idProduto == -1) {
            this.setMensagemValidacao("Selecione um produto!");
            resultado = false;
        } else if ("".equals(this.codBarra)) {
            this.setMensagemValidacao("Informe o código de barras!");
            resultado = false;
        } else if (this.valorCompraProduto == null) {
            this.setMensagemValidacao("Informe uma nome vÃ¡lido!");
            resultado = false;
        } else if (valorVendaProduto == null) {
            this.setMensagemValidacao("Informe uma sexo vÃ¡lido!");
            resultado = false;
        } else if ("".equals(this.dataEntrada)) {
            this.setMensagemValidacao("Informe uma data de Entrada!");
            resultado = false;
        }

        return resultado;
    }
}

package com.vitaanimale.sava.controller;

import com.vitaanimale.sava.business.IAnimaisBO;
import com.vitaanimale.sava.business.IClientesBO;
import com.vitaanimale.sava.business.IFaturamentosBO;
import com.vitaanimale.sava.business.IProdutosBO;
import com.vitaanimale.sava.infra.SavaBusinessException;
import com.vitaanimale.sava.to.Animais;
import com.vitaanimale.sava.to.Clientes;
import com.vitaanimale.sava.to.DescricaoFaturamentos;
import com.vitaanimale.sava.to.Faturamentos;
import com.vitaanimale.sava.to.Servicos;
import com.vitaanimale.sava.to.TiposPagamentos;
import com.vitaanimale.sava.to.TiposProdutos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
public class FaturamentosController extends SAVAAbstractController implements Serializable{
    private static final long serialVersionUID = 1742168426757323415L;
    
    @ManagedProperty("#{clientesBO}")
    @Autowired
    private IClientesBO clientesBO;
    
    @ManagedProperty("#{animaisBO}")
    @Autowired
    private IAnimaisBO animaisBO;
    
    @ManagedProperty("#{produtosBO}")
    @Autowired
    private IProdutosBO produtosBO;
    
    @ManagedProperty("#{faturamentosBO}")
    @Autowired
    private IFaturamentosBO faturamentosBO;
    
    //Tela Lista Faturamentos 
    private Integer idCliente;
    private String  nomeClienteLista;
    private String  cpf;
    private String  telefoneResidencial;
    private String  telefoneCelular;
    
    // Modal Buscar Clientes
    private String nomeClienteBusca;
    private String cpfBusca;
    private String telefoneBusca;
    
    //Tela Cadastro Faturamentos
    private Integer idFaturamento;
    private String  nomeClienteCadastro;
    private Integer idAnimal;
    private String  dataFaturamento;
    private Double  valorTotal;
    private Integer idTipoPagamento;
    private String  recebido;
    private String  obsPagamento;
    private Integer idDescricaoFaturamento;
    private Integer idServico;
    private String  descricao;
    private Integer qtdServico;
    private Double  valorVendaServico;
    private Double  valorVendaServicoOriginal;
    private Double  valorVendaServicoAnterior;
    private Double  valorVenda;
    
    //Modal Buscar Produto
    private Integer idTipoProduto;
    private String  descricaoProduto;
    private String  marca;   
    
    private List<Clientes> listaClientes;
    private List<Faturamentos> listaFaturamentosPorCliente;
    private List<Animais> listaAnimaisPorCliente;
    private List<DescricaoFaturamentos> listaDescricaoFaturamento;
    private List<Servicos> listaServicos;
    private List<TiposProdutos> listaTiposProdutos;
    private List<TiposPagamentos> listaTiposPagamentos;
    private List<DescricaoFaturamentos> listaDescricaoFaturamentoPorFaturamento;

    public IClientesBO getClientesBO() {
        return clientesBO;
    }

    public void setClientesBO(IClientesBO clientesBO) {
        this.clientesBO = clientesBO;
    }
    
    public IAnimaisBO getAnimaisBO() {
        return animaisBO;
    }
    
    public void setAnimaisBO(IAnimaisBO animaisBO) {
        this.animaisBO = animaisBO;
    }

    public IProdutosBO getProdutosBO() {
        return produtosBO;
    }

    public void setProdutosBO(IProdutosBO produtosBO) {
        this.produtosBO = produtosBO;
    }
    
    public IFaturamentosBO getFaturamentosBO() {
        return faturamentosBO;
    }

    public void setFaturamentosBO(IFaturamentosBO faturamentosBO) {
        this.faturamentosBO = faturamentosBO;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeClienteLista() {
        return nomeClienteLista;
    }

    public void setNomeClienteLista(String nomeClienteLista) {
        this.nomeClienteLista = nomeClienteLista;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getNomeClienteBusca() {
        return nomeClienteBusca;
    }

    public void setNomeClienteBusca(String nomeClienteBusca) {
        this.nomeClienteBusca = nomeClienteBusca;
    }

    public String getCpfBusca() {
        return cpfBusca;
    }

    public void setCpfBusca(String cpfBusca) {
        this.cpfBusca = cpfBusca;
    }

    public String getTelefoneBusca() {
        return telefoneBusca;
    }

    public void setTelefoneBusca(String telefoneBusca) {
        this.telefoneBusca = telefoneBusca;
    }

    public Integer getIdFaturamento() {
        return idFaturamento;
    }

    public void setIdFaturamento(Integer idFaturamento) {
        this.idFaturamento = idFaturamento;
    }

    public String getNomeClienteCadastro() {
        return nomeClienteCadastro;
    }

    public void setNomeClienteCadastro(String nomeClienteCadastro) {
        this.nomeClienteCadastro = nomeClienteCadastro;
    }

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getDataFaturamento() {
        return dataFaturamento;
    }

    public void setDataFaturamento(String dataFaturamento) {
        this.dataFaturamento = dataFaturamento;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getIdTipoPagamento() {
        return idTipoPagamento;
    }

    public void setIdTipoPagamento(Integer idTipoPagamento) {
        this.idTipoPagamento = idTipoPagamento;
    }

    public String getRecebido() {
        return recebido;
    }

    public void setRecebido(String recebido) {
        this.recebido = recebido;
    }

    public String getObsPagamento() {
        return obsPagamento;
    }

    public void setObsPagamento(String obsPagamento) {
        this.obsPagamento = obsPagamento;
    }

    public Integer getIdDescricaoFaturamento() {
        return idDescricaoFaturamento;
    }

    public void setIdDescricaoFaturamento(Integer idDescricaoFaturamento) {
        this.idDescricaoFaturamento = idDescricaoFaturamento;
    }

    public Integer getIdServico() {
        return idServico;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQtdServico() {
        return qtdServico;
    }

    public void setQtdServico(Integer qtdServico) {
        this.qtdServico = qtdServico;
    }

    public Double getValorVendaServico() {
        return valorVendaServico;
    }

    public void setValorVendaServico(Double valorVendaServico) {
        this.valorVendaServico = valorVendaServico;
    }

    public Double getValorVendaServicoOriginal() {
        return valorVendaServicoOriginal;
    }

    public void setValorVendaServicoOriginal(Double valorVendaServicoOriginal) {
        this.valorVendaServicoOriginal = valorVendaServicoOriginal;
    }

    public Double getValorVendaServicoAnterior() {
        return valorVendaServicoAnterior;
    }

    public void setValorVendaServicoAnterior(Double valorVendaServicoAnterior) {
        this.valorVendaServicoAnterior = valorVendaServicoAnterior;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Integer getIdTipoProduto() {
        return idTipoProduto;
    }

    public void setIdTipoProduto(Integer idTipoProduto) {
        this.idTipoProduto = idTipoProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public List<Clientes> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Clientes> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Faturamentos> getListaFaturamentosPorCliente() {
        return listaFaturamentosPorCliente;
    }

    public void setListaFaturamentosPorCliente(List<Faturamentos> listaFaturamentosPorCliente) {
        this.listaFaturamentosPorCliente = listaFaturamentosPorCliente;
    }

    public List<Animais> getListaAnimaisPorCliente() {
        return listaAnimaisPorCliente;
    }

    public void setListaAnimaisPorCliente(List<Animais> listaAnimaisPorCliente) {
        this.listaAnimaisPorCliente = listaAnimaisPorCliente;
    }

    public List<DescricaoFaturamentos> getListaDescricaoFaturamento() {
        return listaDescricaoFaturamento;
    }

    public void setListaDescricaoFaturamento(List<DescricaoFaturamentos> listaDescricaoFaturamento) {
        this.listaDescricaoFaturamento = listaDescricaoFaturamento;
    }

    public List<Servicos> getListaServicos() {
        return listaServicos;
    }

    public void setListaServicos(List<Servicos> listaServicos) {
        this.listaServicos = listaServicos;
    }

    public List<TiposProdutos> getListaTiposProdutos() {
        return listaTiposProdutos;
    }

    public void setListaTiposProdutos(List<TiposProdutos> listaTiposProdutos) {
        this.listaTiposProdutos = listaTiposProdutos;
    }

    public List<TiposPagamentos> getListaTiposPagamentos() {
        return listaTiposPagamentos;
    }

    public void setListaTiposPagamentos(List<TiposPagamentos> listaTiposPagamentos) {
        this.listaTiposPagamentos = listaTiposPagamentos;
    }

    public List<DescricaoFaturamentos> getListaDescricaoFaturamentoPorFaturamento() {
        return listaDescricaoFaturamentoPorFaturamento;
    }

    public void setListaDescricaoFaturamentoPorFaturamento(List<DescricaoFaturamentos> listaDescricaoFaturamentoPorFaturamento) {
        this.listaDescricaoFaturamentoPorFaturamento = listaDescricaoFaturamentoPorFaturamento;
    }
     
    public Collection<SelectItem> getCollectionAnimais() {
        Collection<SelectItem> collectionAnimais = new ArrayList<>();
        collectionAnimais.add(new SelectItem(-1, "Selecione..."));
        for (Animais animal : listaAnimaisPorCliente) {
            collectionAnimais.add(new SelectItem(animal.getIdAnimal(), animal.getNomeAnimal()));
        }

        return collectionAnimais;
    }

    public Collection<SelectItem> getCollectionTiposProdutos() {
        Collection<SelectItem> collectionTiposProdutos = new ArrayList<>();
        collectionTiposProdutos.add(new SelectItem(-1, "Selecione..."));
        for (TiposProdutos tipoProduto : listaTiposProdutos) {
            collectionTiposProdutos.add(new SelectItem(tipoProduto.getIdTipoProduto(), tipoProduto.getDescricaoTipoProduto()));
        }

        return collectionTiposProdutos;
    }
    
    public Collection<SelectItem> getCollectionTiposPagamentos() {
        Collection<SelectItem> collectionTiposPagamentos = new ArrayList<>();
        collectionTiposPagamentos.add(new SelectItem(-1, "Selecione..."));
        for (TiposPagamentos tipoPagamento : listaTiposPagamentos) {
            collectionTiposPagamentos.add(new SelectItem(tipoPagamento.getIdTipoPagamento(), tipoPagamento.getDescricaoTipoPagamento()));
        }

        return collectionTiposPagamentos;
    }
    
    public Collection<SelectItem> getCollectionServicos() {
        Collection<SelectItem> collectionServicos = new ArrayList<>();
        collectionServicos.add(new SelectItem(-1, "Selecione..."));
        for (Servicos servico : listaServicos) {
            collectionServicos.add(new SelectItem(servico.getIdServico(), servico.getDescricaoServico()));
        }

        return collectionServicos;
    }
    
    public String init() {
        FacesContext initFaturamentoContext = FacesContext.getCurrentInstance();

        try {
            this.idCliente = null;
            this.nomeClienteLista ="";
            this.cpf = "";
            this.telefoneResidencial = "";
            this.telefoneCelular = "";
            
            this.nomeClienteBusca = "";
            this.cpfBusca = "";
            this.telefoneBusca = "";
            
            this.idFaturamento = null;
            this.nomeClienteCadastro = "";
            this.idAnimal = null;
            this.dataFaturamento = "";
            this.valorTotal = 0.0;
            this.idTipoPagamento = null;
            this.recebido = "";
            this.obsPagamento = "";
            this.idDescricaoFaturamento = null;
            this.idServico = -1;
            this.descricao = "";
            this.qtdServico = null;
            this.valorVendaServico = null;
            this.valorVendaServicoOriginal = null;
            this.valorVendaServicoAnterior = null;
            this.valorVenda = null;
            
            this.idTipoProduto = null;
            this.descricaoProduto = "";
            this.marca = "";
            
            this.listaFaturamentosPorCliente = null;
            this.listaClientes = null;
            this.listaAnimaisPorCliente = null;
            this.listaDescricaoFaturamento = null;
            this.listaServicos = faturamentosBO.buscarListaServicos();
            this.listaTiposProdutos = produtosBO.buscarTiposProdutos();
            this.listaTiposPagamentos = faturamentosBO.buscarTiposPagamentos();
        } catch (SavaBusinessException e) {
            initFaturamentoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "NÃ£o foi possÃ­vel iniciar o Cadastro de Faturamentos!"));
        }

        this.controlarExibicao(false, true);

        return "/pages/cadastro/faturamentos?faces-redirect=true";
    }
    
    public String buscarClientesComParametro() {
        FacesContext buscarClienteContext = FacesContext.getCurrentInstance();

        try {
            listaClientes = clientesBO.buscarClientesComParametro(cpfBusca, nomeClienteBusca, telefoneBusca);
        } catch (SavaBusinessException e) {
            buscarClienteContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "NÃ£o foi possÃ­vel buscar o cliente!"));
        }

        return ACTION_INPUT;
    }

    public String selecionarCliente(Clientes cliente) {
        FacesContext selecionarClienteContext = FacesContext.getCurrentInstance();
        
        if (cliente != null) {
            this.idCliente = cliente.getIdCliente();
            this.nomeClienteLista = cliente.getNomeCliente();
            this.cpf = cliente.getCpf();
            this.telefoneResidencial = cliente.getTelefoneResidencial();
            this.telefoneCelular = cliente.getTelefoneCelular();
            
            this.nomeClienteCadastro = cliente.getNomeCliente();

            try {
                this.listaAnimaisPorCliente = animaisBO.buscarAnimaisPorIdCliente(this.idCliente);
                this.listaFaturamentosPorCliente = faturamentosBO.buscarFaturamentosPorCliente(this.idCliente);
            } catch (SavaBusinessException e) {
                selecionarClienteContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "NÃ£o foi possÃ­vel buscar a lista de faturamentos por cliente!"));
            }
        }

        return ACTION_INPUT;
    }
    
    public String novo() {
        FacesContext novoFaturamentoContext = FacesContext.getCurrentInstance();
        
        if(this.idCliente != null){
            this.idFaturamento = null;
            this.idAnimal = -1;
            this.dataFaturamento = "";
            this.valorTotal = 0.0;
            this.idTipoPagamento = -1;
            this.recebido = "N";
            this.obsPagamento = "";
            this.idDescricaoFaturamento = null;
            this.idServico = -1;
            this.descricao = "";
            this.qtdServico = null;
            this.valorVendaServico = null;
            this.valorVendaServicoOriginal = null;
            this.valorVendaServicoAnterior = 0.0;
            this.valorVenda = null;
            this.listaDescricaoFaturamento = null;
            
            this.controlarExibicao(true, false);
        } else {
            novoFaturamentoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Primeiro selecione um cliente!"));
        }

        return ACTION_INPUT;
    }
    
    public String selecionarFaturamento(Faturamentos faturamento) {
        FacesContext selecionarFaturamentoContext = FacesContext.getCurrentInstance();
        
        if (faturamento != null) {
            this.idFaturamento = faturamento.getIdFaturamento();
            this.idAnimal = faturamento.getIdAnimal();
            this.dataFaturamento = faturamento.getDataFaturamento();
            this.valorTotal = faturamento.getValorTotal();
            this.idTipoPagamento = faturamento.getIdTipoPagamento();
            this.recebido = faturamento.getRecebido();
            this.obsPagamento = faturamento.getObsPagamento();
            
            this.idServico = -1;
            this.qtdServico = null;
            this.valorVendaServico = null;
            this.valorVendaServicoOriginal = null;
            this.valorVendaServicoAnterior = 0.0;
            
            try {
                this.listaDescricaoFaturamentoPorFaturamento = faturamentosBO.buscarDescricaoFaturamentosPorFaturamento(this.idFaturamento);
            } catch(SavaBusinessException e) {
                selecionarFaturamentoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "NÃ£o foi possÃ­vel buscar os itens do faturamento!"));
            }
            this.controlarExibicao(true, false);
        }

        return ACTION_INPUT;
    }
    
    public String salvarFaturamento() {
        FacesContext salvarFaturamentoContext = FacesContext.getCurrentInstance();
        Integer linhasAfetadas = 0;

        if (this.validaDados()) {
            Faturamentos faturamentoFormulario = new Faturamentos(this.idFaturamento, this.idCliente, this.idAnimal, this.dataFaturamento, 
                                                                  this.valorTotal, this.idTipoPagamento, this.recebido, this.obsPagamento);

            try {
                if (this.idFaturamento == null) {
                    linhasAfetadas = faturamentosBO.inserirFaturamento(faturamentoFormulario);
                    
                } else {
                    linhasAfetadas = faturamentosBO.atualizarFaturamento(faturamentoFormulario);
                }
                
                if (linhasAfetadas == 1) {
                    listaFaturamentosPorCliente = faturamentosBO.buscarFaturamentosPorCliente(this.idCliente);
                    salvarFaturamentoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info:", "Faturamento salvo com sucesso!"));
                }
            } catch (SavaBusinessException e) {
                salvarFaturamentoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "NÃ£o foi possÃ­vel salvar o faturamento!"));
            }
        } else {
            salvarFaturamentoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", this.getMensagemValidacao()));
        }

        return ACTION_INPUT;
    }

    private Boolean validaDados() {
        Boolean resultado = true;

        if ("".equals(this.dataFaturamento)) {
            this.setMensagemValidacao("Informe uma data válida!");
            resultado = false;
        } 

        return resultado;
    }
    
    public String buscarValorVendaServico() {
        this.qtdServico = 0;
        this.valorVendaServico = 0.0;
        this.valorVendaServicoOriginal = 0.0;
        this.valorVendaServicoAnterior = 0.0;
        
        Iterator<Servicos> iteServicos = listaServicos.iterator();
        Servicos servico;
        while(iteServicos.hasNext()){
            servico = iteServicos.next();
            if(servico.getIdServico().equals(this.idServico)){
               this.qtdServico = 1;
               this.valorVendaServico = servico.getValorVendaServico();
               this.valorVendaServicoOriginal = servico.getValorVendaServico();
            }
        }

        return ACTION_INPUT;
    }
    
    public String salvarServicoDescricaoFaturamento() {
        FacesContext adicionarServicoDescricaoFaturamentoContext = FacesContext.getCurrentInstance();
        Integer linhasAfetadas = 0;

        if (this.idServico != -1 && !this.qtdServico.equals(0) && !this.valorVendaServico.equals(0)) {
            DescricaoFaturamentos descricaoFaturamentoFormulario = new DescricaoFaturamentos(this.idDescricaoFaturamento, this.idFaturamento, this.idServico, this.qtdServico, this.valorVendaServico, null, null, null);

            try {
                this.valorTotal = this.valorTotal - this.valorVendaServicoAnterior + this.valorVendaServico;
                salvarFaturamento();
                if (this.idDescricaoFaturamento == null) {
                    linhasAfetadas = faturamentosBO.inserirServicoDescricaoFaturamento(descricaoFaturamentoFormulario);
                } else {
                    linhasAfetadas = faturamentosBO.atualizarServicoDescricaoFaturamento(descricaoFaturamentoFormulario);
                }
                
                if (linhasAfetadas == 1) {                   
                    listaFaturamentosPorCliente = faturamentosBO.buscarFaturamentosPorCliente(this.idCliente);
                    listaDescricaoFaturamentoPorFaturamento = faturamentosBO.buscarDescricaoFaturamentosPorFaturamento(this.idFaturamento);
                    this.idServico = -1;
                    this.qtdServico = 0;
                    this.valorVendaServico = 0.0;
                    this.valorVendaServicoOriginal = 0.0;
                    this.valorVendaServicoAnterior = 0.0;
                    adicionarServicoDescricaoFaturamentoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info:", "Serviço salvo com sucesso!"));
                }
            } catch (SavaBusinessException e) {
                adicionarServicoDescricaoFaturamentoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "NÃ£o foi possÃ­vel salvar o servico!"));
            }
        } else {
            adicionarServicoDescricaoFaturamentoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Informe os parâmetros de Serviço corretamente!"));
        }

        return ACTION_INPUT;
    }
    
    public String editarDescricaoFaturamento(DescricaoFaturamentos descricaoFaturamento) {
        if (descricaoFaturamento != null) {
            if(descricaoFaturamento.getTipoDescricaoFaturamento().equals("Serviço")) {
                this.idDescricaoFaturamento = descricaoFaturamento.getIdDescricaoFaturamento();
                this.idServico = descricaoFaturamento.getIdServico();
                this.qtdServico = descricaoFaturamento.getQtdServico();
                this.valorVendaServico = descricaoFaturamento.getValorVendaServico();
                this.valorVendaServicoOriginal = descricaoFaturamento.getValorVendaServico() / this.qtdServico;
                this.valorVendaServicoAnterior = descricaoFaturamento.getValorVendaServico();
            }
        }

        return ACTION_INPUT;
    }
    
    public String selecionarDescricaoFaturamentoExclusao(DescricaoFaturamentos descricaoFaturamento) {
        if (descricaoFaturamento != null) {
            this.idDescricaoFaturamento = descricaoFaturamento.getIdDescricaoFaturamento();
            this.descricao = descricaoFaturamento.getDescricao();
            this.valorVenda = descricaoFaturamento.getValorVenda();
        }

        return ACTION_INPUT;
    }

    public String excluirDescricaoFaturamento() {
        FacesContext excluirDescricaoFaturamentoContext = FacesContext.getCurrentInstance();
        Integer linhasAfetadas = 0;

        if (this.idDescricaoFaturamento != null) {
            try {
                linhasAfetadas = faturamentosBO.excluirDescricaoFaturamento(this.idDescricaoFaturamento);

                if (linhasAfetadas == 1) {
                    this.valorTotal = this.valorTotal - this.valorVenda;
                    salvarFaturamento();
                    listaFaturamentosPorCliente = faturamentosBO.buscarFaturamentosPorCliente(this.idCliente);
                    listaDescricaoFaturamentoPorFaturamento = faturamentosBO.buscarDescricaoFaturamentosPorFaturamento(this.idFaturamento);
                    excluirDescricaoFaturamentoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info:", "Item excluÃ­do com sucesso!"));
                }
            } catch (SavaBusinessException e) {
                excluirDescricaoFaturamentoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "NÃ£o foi possÃ­vel excluir o item!"));
            }
        }

        return ACTION_INPUT;
    }
    
    public String cancelar() {
        this.controlarExibicao(false, true);

        return ACTION_INPUT;
    }
}

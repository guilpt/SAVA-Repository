package com.vitaanimale.sava.controller;

import com.vitaanimale.sava.business.IAnimaisBO;
import com.vitaanimale.sava.business.IClientesBO;
import com.vitaanimale.sava.business.IFaturamentosBO;
import com.vitaanimale.sava.business.IMedicosVeterinariosBO;
import com.vitaanimale.sava.business.IProdutosBO;
import com.vitaanimale.sava.infra.SavaBusinessException;
import com.vitaanimale.sava.to.Animais;
import com.vitaanimale.sava.to.Clientes;
import com.vitaanimale.sava.to.DescricaoFaturamentos;
import com.vitaanimale.sava.to.Faturamentos;
import com.vitaanimale.sava.to.ItensProdutos;
import com.vitaanimale.sava.to.MedicosVeterinarios;
import com.vitaanimale.sava.to.Servicos;
import com.vitaanimale.sava.to.TiposPagamentos;
import com.vitaanimale.sava.to.TiposProdutos;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Elisa
 */
@Controller
@ManagedBean
//@ViewScoped
@SessionScoped //Para imprimir relatório
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
    
    @ManagedProperty("#{medicosVeterinariosBO}")
    @Autowired
    private IMedicosVeterinariosBO medicosVeterinariosBO;
    
    @ManagedProperty("#{dataSource}")
    private DriverManagerDataSource dataSource;
    
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
    private Integer idMedicoVeterinario;
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
    private Integer idProduto;
    private String  codBarra;
    private String  descricaoProduto;
    private Integer qtdProdutoDisponivel;
    private Integer qtdProduto;
    private Double  valorVendaProduto; 
    private Double  valorVendaProdutoOriginal;
    private Double  valorVendaProdutoAnterior;
    private Integer qtdProdutoTemp;
    private String  tipoDescricaoFaturamento;
    private String  codBarraTemp;
    
    private List<Clientes> listaClientes;
    private List<Faturamentos> listaFaturamentosPorCliente;
    private List<Animais> listaAnimaisPorCliente;
    private List<DescricaoFaturamentos> listaDescricaoFaturamento;
    private List<Servicos> listaServicos;
    private List<TiposProdutos> listaTiposProdutos;
    private List<TiposPagamentos> listaTiposPagamentos;
    private List<DescricaoFaturamentos> listaDescricaoFaturamentoPorFaturamento;
    private ItensProdutos itemProduto;
    private List<MedicosVeterinarios> listaMedicosVeterinarios;
    
    private StreamedContent relatorioPDF = null;

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

    public IMedicosVeterinariosBO getMedicosVeterinariosBO() {
        return medicosVeterinariosBO;
    }

    public void setMedicosVeterinariosBO(IMedicosVeterinariosBO medicosVeterinariosBO) {
        this.medicosVeterinariosBO = medicosVeterinariosBO;
    }

    public DriverManagerDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
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

    public Integer getIdMedicoVeterinario() {
        return idMedicoVeterinario;
    }

    public void setIdMedicoVeterinario(Integer idMedicoVeterinario) {
        this.idMedicoVeterinario = idMedicoVeterinario;
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

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public Integer getQtdProdutoDisponivel() {
        return qtdProdutoDisponivel;
    }

    public void setQtdProdutoDisponivel(Integer qtdProdutoDisponivel) {
        this.qtdProdutoDisponivel = qtdProdutoDisponivel;
    }

    public Integer getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(Integer qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public Double getValorVendaProduto() {
        return valorVendaProduto;
    }

    public void setValorVendaProduto(Double valorVendaProduto) {
        this.valorVendaProduto = valorVendaProduto;
    }

    public Double getValorVendaProdutoOriginal() {
        return valorVendaProdutoOriginal;
    }

    public void setValorVendaProdutoOriginal(Double valorVendaProdutoOriginal) {
        this.valorVendaProdutoOriginal = valorVendaProdutoOriginal;
    }

    public Double getValorVendaProdutoAnterior() {
        return valorVendaProdutoAnterior;
    }

    public void setValorVendaProdutoAnterior(Double valorVendaProdutoAnterior) {
        this.valorVendaProdutoAnterior = valorVendaProdutoAnterior;
    }

    public Integer getQtdProdutoTemp() {
        return qtdProdutoTemp;
    }

    public void setQtdProdutoTemp(Integer qtdProdutoTemp) {
        this.qtdProdutoTemp = qtdProdutoTemp;
    }

    public String getTipoDescricaoFaturamento() {
        return tipoDescricaoFaturamento;
    }

    public void setTipoDescricaoFaturamento(String tipoDescricaoFaturamento) {
        this.tipoDescricaoFaturamento = tipoDescricaoFaturamento;
    }

    public String getCodBarraTemp() {
        return codBarraTemp;
    }

    public void setCodBarraTemp(String codBarraTemp) {
        this.codBarraTemp = codBarraTemp;
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

    public ItensProdutos getItemProduto() {
        return itemProduto;
    }

    public void setItemProduto(ItensProdutos itemProduto) {
        this.itemProduto = itemProduto;
    }

    public List<MedicosVeterinarios> getListaMedicosVeterinarios() {
        return listaMedicosVeterinarios;
    }

    public void setListaMedicosVeterinarios(List<MedicosVeterinarios> listaMedicosVeterinarios) {
        this.listaMedicosVeterinarios = listaMedicosVeterinarios;
    }

    public StreamedContent getRelatorioPDF() {
        return relatorioPDF;
    }

    public void setRelatorioPDF(StreamedContent relatorioPDF) {
        this.relatorioPDF = relatorioPDF;
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
    
    public Collection<SelectItem> getCollectionMedicosVeterinarios() {
        Collection<SelectItem> collectionMedicosVeterinarios = new ArrayList<>();
        collectionMedicosVeterinarios.add(new SelectItem(-1, "Selecione..."));
        for (MedicosVeterinarios medicoVeterinario : listaMedicosVeterinarios) {
            collectionMedicosVeterinarios.add(new SelectItem(medicoVeterinario.getIdMedicoVeterinario(), medicoVeterinario.getNomeMedicoVeterinario()));
        }

        return collectionMedicosVeterinarios;
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
            
            this.idMedicoVeterinario = null;
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
            this.idProduto = null;
            this.codBarra = "";
            this.descricaoProduto = "";
            this.qtdProdutoDisponivel = null;
            this.qtdProduto = null;
            this.valorVendaProduto = null;
            this.valorVendaProdutoOriginal = null;
            this.valorVendaProdutoAnterior = null;
            this.qtdProdutoTemp = null;
            this.tipoDescricaoFaturamento = "";
            this.codBarraTemp = null;
            
            this.listaFaturamentosPorCliente = null;
            this.listaClientes = null;
            this.listaAnimaisPorCliente = null;
            this.listaDescricaoFaturamento = null;
            this.listaServicos = faturamentosBO.buscarListaServicos();
            this.listaTiposProdutos = produtosBO.buscarTiposProdutos();
            this.listaTiposPagamentos = faturamentosBO.buscarTiposPagamentos();
            this.itemProduto = null;
            this.listaMedicosVeterinarios = medicosVeterinariosBO.buscarMedicosVeterinariosAtivos();
        } catch (SavaBusinessException e) {
            initFaturamentoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Não foi possível iniciar o Cadastro de Faturamentos!"));
        }

        this.controlarExibicao(false, true);

        return "/pages/cadastro/faturamentos?faces-redirect=true";
    }
    
    public String buscarClientesComParametro() {
        FacesContext buscarClienteContext = FacesContext.getCurrentInstance();

        try {
            listaClientes = clientesBO.buscarClientesComParametro(cpfBusca, nomeClienteBusca, telefoneBusca);
        } catch (SavaBusinessException e) {
            buscarClienteContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Não foi possível buscar o cliente!"));
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
                selecionarClienteContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Não foi possível buscar a lista de faturamentos por cliente!"));
            }
        }

        return ACTION_INPUT;
    }
    
    public String novo() {
        FacesContext novoFaturamentoContext = FacesContext.getCurrentInstance();
        
        if(this.idCliente != null){
            this.idMedicoVeterinario = -1;
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
            this.idProduto = null;
            this.codBarra = "";
            this.descricaoProduto = "";
            this.qtdProdutoDisponivel = null;
            this.qtdProduto = null;
            this.valorVendaProduto = null;
            this.valorVendaProdutoOriginal = null;
            this.valorVendaProdutoAnterior = 0.0;
            this.qtdProdutoTemp = 0;
            this.tipoDescricaoFaturamento = "";
            this.codBarraTemp = "";
            this.listaDescricaoFaturamento = null;
            this.itemProduto = null;
            
            this.controlarExibicao(true, false);
        } else {
            novoFaturamentoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Primeiro selecione um cliente!"));
        }

        return ACTION_INPUT;
    }
    
    public String selecionarFaturamento(Faturamentos faturamento) {
        FacesContext selecionarFaturamentoContext = FacesContext.getCurrentInstance();
        
        if (faturamento != null) {
            this.idMedicoVeterinario = faturamento.getIdMedicoVeterinario();
            this.idFaturamento = faturamento.getIdFaturamento();
            this.idAnimal = faturamento.getIdAnimal();
            this.dataFaturamento = faturamento.getDataFaturamento();
            this.valorTotal = faturamento.getValorTotal();
            this.idTipoPagamento = faturamento.getIdTipoPagamento();
            this.recebido = faturamento.getRecebido();
            this.obsPagamento = faturamento.getObsPagamento();
            
            this.idDescricaoFaturamento = null;
            this.idServico = -1;
            this.descricao = "";
            this.qtdServico = null;
            this.valorVendaServico = null;
            this.valorVendaServicoOriginal = null;
            this.valorVendaServicoAnterior = 0.0;
            this.valorVenda = null;
            this.idProduto = null;
            this.codBarra = "";
            this.descricaoProduto = "";
            this.qtdProdutoDisponivel = null;
            this.qtdProduto = null;
            this.valorVendaProduto = null;
            this.valorVendaProdutoOriginal = null;
            this.valorVendaProdutoAnterior = 0.0;
            this.qtdProdutoTemp = 0;
            this.tipoDescricaoFaturamento = "";
            this.codBarraTemp = "";
            this.listaDescricaoFaturamento = null;
            this.itemProduto = null;
            
            try {
                this.listaDescricaoFaturamentoPorFaturamento = faturamentosBO.buscarDescricaoFaturamentosPorFaturamento(this.idFaturamento);
            } catch(SavaBusinessException e) {
                selecionarFaturamentoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Não foi possível buscar os itens do faturamento!"));
            }
            this.controlarExibicao(true, false);
        }

        return ACTION_INPUT;
    }
    
    public String imprimirFaturamento(Faturamentos faturamento) {
        FacesContext imprimirFaturamentoContext = FacesContext.getCurrentInstance();
        
        if (faturamento != null) {
            try {
               ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
               String caminho = ctx.getRealPath("/");
               
               HashMap parameterMap = new HashMap();
               parameterMap.put("ID_FATURAMENTO", faturamento.getIdFaturamento());
               parameterMap.put("SUBREPORT_DIR", caminho + "/jasperreports/");

               JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(caminho + "/jasperreports/relSAVA_Faturamento.jasper");

               if (dataSource != null) {
                   JasperPrint print = JasperFillManager.fillReport(report, parameterMap, dataSource.getConnection());
                   JRExporter exporter = null;
                   ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                   InputStream inpa = null;

                   exporter = new JRPdfExporter();
                   exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                   exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
                   exporter.exportReport();
                   byte[] dataRelatorioPDF = outputStream.toByteArray();
                   InputStream inp = new ByteArrayInputStream(dataRelatorioPDF);
                   this.relatorioPDF = new DefaultStreamedContent(inp, "application/pdf");
               }
           }catch (Exception ex) {
               ex.printStackTrace();
               imprimirFaturamentoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Não foi possível imprimir o relatório!"));
           }
        }
        
        return ACTION_INPUT;
    }
    
    public String salvarFaturamento() {
        FacesContext salvarFaturamentoContext = FacesContext.getCurrentInstance();
        Integer linhasAfetadas = 0;
        Integer idFaturamento = 0;

        if (this.validaDados()) {
            Faturamentos faturamentoFormulario = new Faturamentos(this.idFaturamento, this.idMedicoVeterinario, this.idCliente, this.idAnimal, this.dataFaturamento, 
                                                                  this.valorTotal, this.idTipoPagamento, this.recebido, this.obsPagamento);

            try {
                if (this.idFaturamento == null) {
                    idFaturamento = faturamentosBO.inserirFaturamento(faturamentoFormulario);
                    this.idFaturamento = idFaturamento;
                } else {
                    linhasAfetadas = faturamentosBO.atualizarFaturamento(faturamentoFormulario);
                    idFaturamento = this.idFaturamento;
                }
                
                if (idFaturamento != 0) {
                    listaFaturamentosPorCliente = faturamentosBO.buscarFaturamentosPorCliente(this.idCliente);
                    salvarFaturamentoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info:", "Faturamento salvo com sucesso!"));
                }
            } catch (SavaBusinessException e) {
                salvarFaturamentoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Não foi possível salvar o faturamento!"));
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
            salvarFaturamento();
            DescricaoFaturamentos descricaoFaturamentoFormulario = new DescricaoFaturamentos(this.idDescricaoFaturamento, this.idFaturamento, this.idServico, this.qtdServico, this.valorVendaServico, null, null, null);

            try {
                
                if (this.idDescricaoFaturamento == null) {
                    linhasAfetadas = faturamentosBO.inserirServicoDescricaoFaturamento(descricaoFaturamentoFormulario);
                } else {
                    linhasAfetadas = faturamentosBO.atualizarServicoDescricaoFaturamento(descricaoFaturamentoFormulario);
                }

                if (linhasAfetadas == 1) {
                    this.valorTotal = this.valorTotal - this.valorVendaServicoAnterior + this.valorVendaServico;
                    salvarFaturamento();
                    listaFaturamentosPorCliente = faturamentosBO.buscarFaturamentosPorCliente(this.idCliente);
                    listaDescricaoFaturamentoPorFaturamento = faturamentosBO.buscarDescricaoFaturamentosPorFaturamento(this.idFaturamento);
                    this.idDescricaoFaturamento = null;
                    this.idServico = -1;
                    this.qtdServico = 0;
                    this.valorVendaServico = 0.0;
                    this.valorVendaServicoOriginal = 0.0;
                    this.valorVendaServicoAnterior = 0.0;
                    adicionarServicoDescricaoFaturamentoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info:", "Serviço salvo com sucesso!"));
                }
            } catch (SavaBusinessException e) {
                adicionarServicoDescricaoFaturamentoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Não foi possível salvar o servico!"));
            }
        } else {
            adicionarServicoDescricaoFaturamentoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Informe os parâmetros de Serviço corretamente!"));
        }

        return ACTION_INPUT;
    }
    
    public String buscarProdutoPorCodBarra() {
        FacesContext buscarProdutoPorCodBarraContext = FacesContext.getCurrentInstance();
        
        this.idProduto = null;
        this.qtdProduto = 0;
        this.valorVendaProduto = 0.0;
        this.valorVendaProdutoOriginal = 0.0;
        this.valorVendaProdutoAnterior = 0.0;
        
        if(!this.codBarra.equals("")) {
            try {
                itemProduto = faturamentosBO.buscarProdutoPorCodBarra(this.codBarra);
                
                this.idProduto = itemProduto.getIdProduto();
                this.descricaoProduto = itemProduto.getDescricaoProduto();
                this.qtdProdutoDisponivel = itemProduto.getQtdProdutoDisponivel();
                this.qtdProduto = 1;
                this.valorVendaProduto = itemProduto.getValorVendaProduto();
                this.valorVendaProdutoOriginal = itemProduto.getValorVendaProduto();
            } catch(SavaBusinessException e) {
                this.idProduto = null;
                this.qtdProduto = 0;
                this.valorVendaProduto = 0.0;
                this.valorVendaProdutoOriginal = 0.0;
                this.valorVendaProdutoAnterior = 0.0;
                buscarProdutoPorCodBarraContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Produto não encontrado!"));
            }
        }
        
        return ACTION_INPUT;
    }
    
    public String salvarProdutoDescricaoFaturamento() {
        FacesContext salvarProdutoDescricaoFaturamentoContext = FacesContext.getCurrentInstance();
        Integer linhasAfetadas = 0;
        Integer idDescricaoFaturamento = 0;
        List<ItensProdutos> listaItensProdutos = null;

        if (this.idProduto != null && !this.qtdProduto.equals(0) && !this.valorVendaProduto.equals(0)) {
            if(this.qtdProduto <= this.qtdProdutoDisponivel) {
                salvarFaturamento();
                DescricaoFaturamentos descricaoFaturamentoFormulario = new DescricaoFaturamentos(this.idDescricaoFaturamento, this.idFaturamento, null, null, null, this.idProduto, this.qtdProduto, this.valorVendaProduto);

                try {
                    
                    if (this.idDescricaoFaturamento == null) {
                        idDescricaoFaturamento = faturamentosBO.inserirProdutoDescricaoFaturamento(descricaoFaturamentoFormulario);
                    } else {
                        linhasAfetadas = faturamentosBO.atualizarProdutoDescricaoFaturamento(descricaoFaturamentoFormulario);
                        idDescricaoFaturamento = this.idDescricaoFaturamento;
                    }

                    if (idDescricaoFaturamento != 0) { 
                        this.valorTotal = this.valorTotal - this.valorVendaProdutoAnterior + this.valorVendaProduto;
                        salvarFaturamento();
                        if (this.qtdProduto > this.qtdProdutoTemp) { //SaÃƒÂ­da de itens
                            for(Integer i = 1; i <= (this.qtdProduto - this.qtdProdutoTemp); i++) {
                                faturamentosBO.atualizarSaidaItensProdutos(this.codBarra, this.valorVendaProduto / this.qtdProduto, idDescricaoFaturamento, "S");
                            }
                            listaItensProdutos = faturamentosBO.buscarListaItensProdutosPorDescricaoFaturamento(idDescricaoFaturamento);
                            for(ItensProdutos itemProduto : listaItensProdutos) {
                                faturamentosBO.atualizarValorVendaProdutoItensProdutos(this.valorVendaProduto / this.qtdProduto, itemProduto.getIdItemProduto());
                            }
                        } else if (this.qtdProduto < this.qtdProdutoTemp) { //DevoluÃƒÂ§ÃƒÂ£o de itens
                            for(Integer i = 1; i <= (this.qtdProdutoTemp - this.qtdProduto); i++) {
                                faturamentosBO.atualizarSaidaItensProdutos(this.codBarra, this.valorVendaProdutoOriginal, null, "D");
                            }
                            listaItensProdutos = faturamentosBO.buscarListaItensProdutosPorDescricaoFaturamento(idDescricaoFaturamento);
                            for(ItensProdutos itemProduto : listaItensProdutos) {
                                faturamentosBO.atualizarValorVendaProdutoItensProdutos(this.valorVendaProduto / this.qtdProduto, itemProduto.getIdItemProduto());
                            }
                        } else if (this.qtdProduto == this.qtdProdutoTemp) {
                            listaItensProdutos = faturamentosBO.buscarListaItensProdutosPorDescricaoFaturamento(idDescricaoFaturamento);
                            for(ItensProdutos itemProduto : listaItensProdutos) {
                                faturamentosBO.atualizarValorVendaProdutoItensProdutos(this.valorVendaProduto, itemProduto.getIdItemProduto());
                            }
                        }

                        listaFaturamentosPorCliente = faturamentosBO.buscarFaturamentosPorCliente(this.idCliente);
                        listaDescricaoFaturamentoPorFaturamento = faturamentosBO.buscarDescricaoFaturamentosPorFaturamento(this.idFaturamento);
                        this.codBarra = "";
                        this.descricaoProduto = "";
                        this.qtdProdutoDisponivel = 0;
                        this.idDescricaoFaturamento = null;
                        this.idProduto = null;
                        this.qtdProduto = 0;
                        this.qtdProdutoTemp = 0;
                        this.valorVendaProduto = 0.0;
                        this.valorVendaProdutoOriginal = 0.0;
                        this.valorVendaProdutoAnterior = 0.0;
                        salvarProdutoDescricaoFaturamentoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info:", "Produto salvo com sucesso!"));
                    }
                } catch (SavaBusinessException e) {
                    salvarProdutoDescricaoFaturamentoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Não foi possível salvar o produto!"));
                }
            } else {
                salvarProdutoDescricaoFaturamentoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Não existem produtos suficientes!"));
            }
        } else {
            salvarProdutoDescricaoFaturamentoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Informe os parâmetros do Produto corretamente!"));
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
            } else if(descricaoFaturamento.getTipoDescricaoFaturamento().equals("Produto")) {
                this.codBarra = descricaoFaturamento.getCodBarra();
                buscarProdutoPorCodBarra();
                this.idDescricaoFaturamento = descricaoFaturamento.getIdDescricaoFaturamento();
                this.idProduto = descricaoFaturamento.getIdProduto();
                this.qtdProduto = descricaoFaturamento.getQtdProduto();
                this.qtdProdutoTemp = descricaoFaturamento.getQtdProduto();
                this.qtdProdutoDisponivel = this.qtdProdutoDisponivel + descricaoFaturamento.getQtdProduto();
                this.valorVendaProduto = descricaoFaturamento.getValorVendaProduto();
                this.valorVendaProdutoOriginal = descricaoFaturamento.getValorVendaProduto() / this.qtdProduto;
                this.valorVendaProdutoAnterior = descricaoFaturamento.getValorVendaProduto();
            }
        }

        return ACTION_INPUT;
    }
    
    public String selecionarDescricaoFaturamentoExclusao(DescricaoFaturamentos descricaoFaturamento) {
        if (descricaoFaturamento != null) {
            this.idDescricaoFaturamento = descricaoFaturamento.getIdDescricaoFaturamento();
            this.descricao = descricaoFaturamento.getDescricao();
            this.valorVenda = descricaoFaturamento.getValorVenda();
            this.tipoDescricaoFaturamento = descricaoFaturamento.getTipoDescricaoFaturamento();
            if (descricaoFaturamento.getTipoDescricaoFaturamento().equals("Produto")){
                this.codBarraTemp = descricaoFaturamento.getCodBarra();
                this.qtdProdutoTemp = descricaoFaturamento.getQtd();
            }
        }

        return ACTION_INPUT;
    }

    public String excluirDescricaoFaturamento() {
        FacesContext excluirDescricaoFaturamentoContext = FacesContext.getCurrentInstance();
        Integer linhasAfetadas = 0;

        if (this.idDescricaoFaturamento != null) {
            try {
                if (this.tipoDescricaoFaturamento.equals("Produto")) {
                    for (Integer i = 1; i <= this.qtdProdutoTemp; i++) {
                        faturamentosBO.atualizarSaidaItensProdutos(this.codBarraTemp, this.valorVenda, null, "D");
                    }
                }
                linhasAfetadas = faturamentosBO.excluirDescricaoFaturamento(this.idDescricaoFaturamento);

                if (linhasAfetadas == 1) {
                    this.valorTotal = this.valorTotal - this.valorVenda;
                    salvarFaturamento();
                    this.codBarraTemp = "";
                    listaFaturamentosPorCliente = faturamentosBO.buscarFaturamentosPorCliente(this.idCliente);
                    listaDescricaoFaturamentoPorFaturamento = faturamentosBO.buscarDescricaoFaturamentosPorFaturamento(this.idFaturamento);
                    excluirDescricaoFaturamentoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info:", "Item excluído com sucesso!"));
                }
            } catch (SavaBusinessException e) {
                excluirDescricaoFaturamentoContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Não foi possível excluir o item!"));
            }
        }

        return ACTION_INPUT;
    }
    
    public String voltar() {
        this.controlarExibicao(false, true);

        return ACTION_INPUT;
    }
}

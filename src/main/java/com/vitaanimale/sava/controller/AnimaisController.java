package com.vitaanimale.sava.controller;

import com.vitaanimale.sava.business.IAnimaisBO;
import com.vitaanimale.sava.business.IClientesBO;
import com.vitaanimale.sava.infra.SavaBusinessException;
import com.vitaanimale.sava.to.Clientes;
import com.vitaanimale.sava.to.Especies;
import com.vitaanimale.sava.to.Racas;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Elisa
 */
@Controller
@ManagedBean
@ViewScoped
public class AnimaisController extends SAVAController implements Serializable{
    private static final long serialVersionUID = 1741168426757323415L;
    
    @ManagedProperty("#{animaisBO}")
    @Autowired
    private IAnimaisBO animaisBO;
    
    @ManagedProperty("#{clientesBO}")
    @Autowired
    private IClientesBO clientesBO;
    
    private Integer idAnimal;
    private Integer idCliente;
    private String  especie;
    private String  raca;
    private String  nomeAnimal;
    private String  sexo;
    private String  corPelagem;
    private Integer idadeAno;
    private Integer idadeMes;
    private Double  peso;
    private String  obito;
    private String  disponibilidadeCruzamento; 
    
    private String  nomeCliente;
    private String  cpf;
    private String  telefoneResidencial;
    private String  telefoneCelular;
    private String  telefoneBusca;
    
    private Boolean modalBuscarCliente;
    
    private List<Clientes> listaClientes;
    private List<Especies> listaEspecies;
    private List<Racas>    listaRacas;

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCorPelagem() {
        return corPelagem;
    }

    public void setCorPelagem(String corPelagem) {
        this.corPelagem = corPelagem;
    }

    public Integer getIdadeAno() {
        return idadeAno;
    }

    public void setIdadeAno(Integer idadeAno) {
        this.idadeAno = idadeAno;
    }

    public Integer getIdadeMes() {
        return idadeMes;
    }

    public void setIdadeMes(Integer idadeMes) {
        this.idadeMes = idadeMes;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getObito() {
        return obito;
    }

    public void setObito(String obito) {
        this.obito = obito;
    }

    public String getDisponibilidadeCruzamento() {
        return disponibilidadeCruzamento;
    }

    public void setDisponibilidadeCruzamento(String disponibilidadeCruzamento) {
        this.disponibilidadeCruzamento = disponibilidadeCruzamento;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
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

    public String getTelefoneBusca() {
        return telefoneBusca;
    }

    public void setTelefoneBusca(String telefoneBusca) {
        this.telefoneBusca = telefoneBusca;
    }

    public Boolean getModalBuscarCliente() {
        return modalBuscarCliente;
    }

    public void setModalBuscarCliente(Boolean modalBuscarCliente) {
        this.modalBuscarCliente = modalBuscarCliente;
    }

    public List<Clientes> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Clientes> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Especies> getListaEspecies() {
        return listaEspecies;
    }

    public void setListaEspecies(List<Especies> listaEspecies) {
        this.listaEspecies = listaEspecies;
    }

    public List<Racas> getListaRacas() {
        return listaRacas;
    }

    public void setListaRacas(List<Racas> listaRacas) {
        this.listaRacas = listaRacas;
    }
    
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        try{
            this.listaEspecies = animaisBO.buscarEspecies();
        } catch(SavaBusinessException e){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Não foi possível buscar a lista de espécies!"));
        }
        
        this.modalBuscarCliente = false;
        this.controlarExibicao(false, true);
        
        this.idCliente = 1;
        this.nomeCliente = "Guilherme Palhares Theodoro";
        this.cpf = "731.685.481.20";
        this.telefoneCelular = "(34) 9275-8556";
        this.telefoneResidencial = "(34) 3227-5404";   
    }
    
    public String abrirModalBuscarCliente() {
        this.modalBuscarCliente = true;
        
        return ACTION_INPUT;
    }
    
    public String novo() {
        this.idAnimal  = null;
        this.idCliente = null;
        this.especie = "";
        this.raca = "";
        this.nomeAnimal = "";
        this.sexo = "";
        this.corPelagem = "";
        this.idadeAno = null;
        this.idadeMes = null;
        this.peso = null;
        this.obito = "N";
        this.disponibilidadeCruzamento = "N";

        this.controlarExibicao(true, false);

        return ACTION_INPUT;
    }
    
    public String salvarAnimal() {
        
        return ACTION_INPUT;
    }
    
    public String cancelar(){
        this.controlarExibicao(false, true);
        
        return ACTION_INPUT;
    }
    
    public String buscarClientesComParametro() {
        FacesContext context = FacesContext.getCurrentInstance();
        
        try{
            listaClientes = clientesBO.buscarClientesComParametro(cpf, nomeCliente, telefoneBusca);
        } catch(SavaBusinessException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Não foi possível buscar o cliente!"));
        }
        return ACTION_INPUT;
    }
    
    public String selecionarCliente(Clientes cliente) {
        if (cliente != null) {
            this.idCliente = cliente.getIdCliente();
            this.nomeCliente = cliente.getNomeCliente();
            this.cpf = cliente.getCpf();
            this.telefoneResidencial = cliente.getTelefoneResidencial();
            this.telefoneCelular = cliente.getTelefoneCelular();

            this.controlarExibicao(true, false);
        }

        return ACTION_INPUT;
    }
    
}

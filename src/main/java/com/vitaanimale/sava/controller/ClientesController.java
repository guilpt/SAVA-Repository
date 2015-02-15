package com.vitaanimale.sava.controller;

import com.vitaanimale.sava.business.impl.ClientesBOImpl;
import com.vitaanimale.sava.infra.SavaBusinessException;
import com.vitaanimale.sava.to.Clientes;
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
public class ClientesController implements Serializable {

    private static final long serialVersionUID = 685949097784188252L;

    @ManagedProperty("#{clientesBO}")
    @Autowired
    private ClientesBOImpl clientesBO;

    private List<Clientes> listaClientes;

    private Integer idCliente;
    private String nomeCliente;
    private String cpf;
    private String sexo;
    private String dataNascimento;
    private String endereco;
    private String telefoneResidencial;
    private String telefoneCelular;
    private String email;

    private String mensagemValidacao;
    private Boolean mostrarLista = true;
    private Boolean mostrarFormulario = false;

    public ClientesBOImpl getClientesBO() {
        return clientesBO;
    }

    public void setClientesBO(ClientesBOImpl clientesBO) {
        this.clientesBO = clientesBO;
    }

    public List<Clientes> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Clientes> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensagemValidacao() {
        return mensagemValidacao;
    }

    public void setMensagemValidacao(String mensagemValidacao) {
        this.mensagemValidacao = mensagemValidacao;
    }

    public Boolean getMostrarLista() {
        return mostrarLista;
    }

    public void setMostrarLista(Boolean mostrarLista) {
        this.mostrarLista = mostrarLista;
    }

    public Boolean getMostrarFormulario() {
        return mostrarFormulario;
    }

    public void setMostrarFormulario(Boolean mostrarFormulario) {
        this.mostrarFormulario = mostrarFormulario;
    }

    @PostConstruct
    public void init() {
        try {
            this.controlarExibicao(false, true);
            listaClientes = clientesBO.buscarClientes();
        } catch (SavaBusinessException e) {
            e.printStackTrace();
        }
    }

    private void controlarExibicao(Boolean bForm, Boolean bLista) {
        this.mostrarFormulario = bForm;
        this.mostrarLista = bLista;
    }

    public String novo() {
        //this.clienteFormulario = new Clientes();
        this.idCliente = null;
        this.nomeCliente = "";
        this.cpf = "";
        this.sexo = "";
        this.dataNascimento = "";
        this.endereco = "";
        this.telefoneResidencial = "";
        this.telefoneCelular = "";
        this.email = "";

        this.controlarExibicao(true, false);

        return "";
    }

    public String salvarCliente() {
        FacesContext context = FacesContext.getCurrentInstance();
        Integer linhasAfetadas = 0;

        if (this.validaDados()) {
            Clientes clienteFormulario = new Clientes(this.idCliente, this.nomeCliente, this.cpf, this.sexo, this.dataNascimento, this.endereco, this.telefoneResidencial, this.telefoneCelular, email);
            
            try {
                if (this.idCliente == null) {
                    linhasAfetadas = clientesBO.inserirCliente(clienteFormulario);
                } else {
                    linhasAfetadas = clientesBO.atualizarCliente(clienteFormulario);
                }

                if (linhasAfetadas == 1) {
                    this.init();
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info:", "Cliente salvo com sucesso!"));
                }
            } catch (SavaBusinessException e) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Não foi possível salvar o cliente!"));
            }
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", this.mensagemValidacao));
        }

        return "";
    }

    private Boolean validaDados() {
        Boolean resultado = true;

        if ("".equals(this.nomeCliente) || this.nomeCliente.length() < 10) {
            this.mensagemValidacao = "Informe um nome válido!";
            resultado = false;
        } else if (this.cpf.length() < 14) {
            this.mensagemValidacao = "Informe um CPF válido!";
            resultado = false;
        } else if ("-1".equals(this.sexo)) {
            this.mensagemValidacao = "Informe um sexo válido!";
            resultado = false;
        } else if (this.dataNascimento.length() < 10) {
            this.mensagemValidacao = "Informe uma data de nascimento válida!";
            resultado = false;
        }

        return resultado;
    }

    public String cancelar() {
        this.controlarExibicao(false, true);

        return "";
    }

    public String selecionarCliente(Clientes cliente) {
        if (cliente != null) {
            //this.clienteFormulario = cliente;
            this.idCliente = cliente.getIdCliente();
            this.nomeCliente = cliente.getNomeCliente();
            this.cpf = cliente.getCpf();
            this.sexo = cliente.getSexo();
            this.dataNascimento = cliente.getDataNascimento();
            this.endereco = cliente.getEndereco();
            this.telefoneResidencial = cliente.getTelefoneResidencial();
            this.telefoneCelular = cliente.getTelefoneCelular();
            this.email = cliente.getEmail();

            this.controlarExibicao(true, false);
        }

        return "";
    }

    public String excluirCliente(Clientes cliente) {
        FacesContext context = FacesContext.getCurrentInstance();
        Integer linhasAfetadas = 0;

        if (cliente != null) {
            try {
                linhasAfetadas = clientesBO.excluirCliente(cliente.getIdCliente());

                if (linhasAfetadas == 1) {
                    this.init();
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info:", "Cliente excluído com sucesso!"));
                }
            } catch (SavaBusinessException e) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Não foi possível excluir o cliente!"));
            }
        }

        return "";
    }

}

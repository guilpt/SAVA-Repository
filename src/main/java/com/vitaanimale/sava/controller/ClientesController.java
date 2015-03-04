package com.vitaanimale.sava.controller;

import com.vitaanimale.sava.business.IClientesBO;
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
public class ClientesController extends SAVAAbstractController implements Serializable {

    private static final long serialVersionUID = 685949097784188252L;

    @ManagedProperty("#{clientesBO}")
    @Autowired
    private IClientesBO clientesBO;

    private List<Clientes> listaClientes;

    private Integer idCliente;
    private String  nomeCliente;
    private String  cpf;
    private String  sexoCliente;
    private String  dataNascimento;
    private String  endereco;
    private String  telefoneResidencial;
    private String  telefoneCelular;
    private String  email;

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

    public String getSexoCliente() {
        return sexoCliente;
    }

    public void setSexoCliente(String sexoCliente) {
        this.sexoCliente = sexoCliente;
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

    @PostConstruct
    public void init() {
        try {
            this.controlarExibicao(false, true);
            listaClientes = clientesBO.buscarClientes();
        } catch (SavaBusinessException e) {
            e.printStackTrace();
        }
    }

    public String novo() {
        this.idCliente = null;
        this.nomeCliente = "";
        this.cpf = "";
        this.sexoCliente = "";
        this.dataNascimento = "";
        this.endereco = "";
        this.telefoneResidencial = "";
        this.telefoneCelular = "";
        this.email = "";

        this.controlarExibicao(true, false);

        return ACTION_INPUT;
    }

    public String salvarCliente() {
        FacesContext context = FacesContext.getCurrentInstance();
        Integer linhasAfetadas = 0;

        if (this.validaDados()) {
            Clientes clienteFormulario = new Clientes(this.idCliente, this.nomeCliente, this.cpf, this.sexoCliente, this.dataNascimento, this.endereco, this.telefoneResidencial, this.telefoneCelular, email);

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
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", this.getMensagemValidacao()));
        }

        return ACTION_INPUT;
    }

    private Boolean validaDados() {
        Boolean resultado = true;

        if ("".equals(this.nomeCliente) || this.nomeCliente.length() < 10) {
            this.setMensagemValidacao("Informe um nome válido!");
            resultado = false;
        } else if (this.cpf.length() < 14) {
            this.setMensagemValidacao("Informe um CPF válido!");
            resultado = false;
        } else if ("-1".equals(this.sexoCliente)) {
            this.setMensagemValidacao("Informe um sexo válido!");
            resultado = false;
        } else if (this.dataNascimento.length() < 10) {
            this.setMensagemValidacao("Informe uma data de nascimento válida!");
            resultado = false;
        }

        return resultado;
    }

    public String cancelar() {
        this.controlarExibicao(false, true);

        return ACTION_INPUT;
    }

    public String selecionarCliente(Clientes cliente) {
        if (cliente != null) {
            this.idCliente = cliente.getIdCliente();
            this.nomeCliente = cliente.getNomeCliente();
            this.cpf = cliente.getCpf();
            this.sexoCliente = cliente.getSexoCliente();
            this.dataNascimento = cliente.getDataNascimento();
            this.endereco = cliente.getEndereco();
            this.telefoneResidencial = cliente.getTelefoneResidencial();
            this.telefoneCelular = cliente.getTelefoneCelular();
            this.email = cliente.getEmail();

            this.controlarExibicao(true, false);
        }

        return ACTION_INPUT;
    }

    public String selecionarClienteExclusao(Clientes cliente) {
        if (cliente != null) {
            this.idCliente = cliente.getIdCliente();
            this.nomeCliente = cliente.getNomeCliente();
        }

        return ACTION_INPUT;
    }

    public String excluirCliente() {
        FacesContext context = FacesContext.getCurrentInstance();
        Integer linhasAfetadas = 0;

        if (this.idCliente != null) {
            try {
                linhasAfetadas = clientesBO.excluirCliente(this.idCliente);

                if (linhasAfetadas == 1) {
                    this.init();
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info:", "Cliente excluído com sucesso!"));
                }
            } catch (SavaBusinessException e) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", e.getMessage()));
            } finally {
                this.idCliente = null;
                this.nomeCliente = "";
            }
        }

        return ACTION_INPUT;
    }

}

package com.vitaanimale.sava.controller;
import com.vitaanimale.sava.business.IMedicosVeterinariosBO;
import com.vitaanimale.sava.infra.SavaBusinessException;
import com.vitaanimale.sava.to.Clientes;
import com.vitaanimale.sava.to.MedicosVeterinarios;
import java.io.Serializable;
import java.util.List;
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
public class MedicosVeterinariosController extends SAVAAbstractController implements Serializable{
    
    
    @ManagedProperty("#{medicosVeterinariosBO}")
    @Autowired
    private IMedicosVeterinariosBO medicosVeterinariosBO;

    private List<MedicosVeterinarios> listaMedicosVeterinarios;
    
    private Integer idMedicoVeterinario;
    private String  nomeMedicoVeterinario;
    private String  ufCRMV;
    private Integer nroCRMV;
    private String  sexoMedicoVeterinario;
    private String  telefoneCelular;
    private String  indAtivo;

    public IMedicosVeterinariosBO getMedicosVeterinariosBO() {
        return medicosVeterinariosBO;
    }

    public void setMedicosVeterinariosBO(IMedicosVeterinariosBO medicosVeterinariosBO) {
        this.medicosVeterinariosBO = medicosVeterinariosBO;
    }

    public List<MedicosVeterinarios> getListaMedicosVeterinarios() {
        return listaMedicosVeterinarios;
    }

    public void setListaMedicosVeterinarios(List<MedicosVeterinarios> listaMedicosVeterinarios) {
        this.listaMedicosVeterinarios = listaMedicosVeterinarios;
    }

    public Integer getIdMedicoVeterinario() {
        return idMedicoVeterinario;
    }

    public void setIdMedicoVeterinario(Integer idMedicoVeterinario) {
        this.idMedicoVeterinario = idMedicoVeterinario;
    }

    public String getNomeMedicoVeterinario() {
        return nomeMedicoVeterinario;
    }

    public void setNomeMedicoVeterinario(String nomeMedicoVeterinario) {
        this.nomeMedicoVeterinario = nomeMedicoVeterinario;
    }

    public String getUfCRMV() {
        return ufCRMV;
    }

    public void setUfCRMV(String ufCRMV) {
        this.ufCRMV = ufCRMV;
    }

    public Integer getNroCRMV() {
        return nroCRMV;
    }

    public void setNroCRMV(Integer nroCRMV) {
        this.nroCRMV = nroCRMV;
    }

    public String getSexoMedicoVeterinario() {
        return sexoMedicoVeterinario;
    }

    public void setSexoMedicoVeterinario(String sexoMedicoVeterinario) {
        this.sexoMedicoVeterinario = sexoMedicoVeterinario;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getIndAtivo() {
        return indAtivo;
    }

    public void setIndAtivo(String indAtivo) {
        this.indAtivo = indAtivo;
    }
    
    public String init() {
        try {
            this.controlarExibicao(false, true);
            listaMedicosVeterinarios = medicosVeterinariosBO.buscarMedicosVeterinarios();
        } catch (SavaBusinessException e) {
            e.printStackTrace();
        }
        
        return "/pages/cadastro/medicosVeterinarios?faces-redirect=true";
    }

    public String novo() {
        this.idMedicoVeterinario = null;
        this.nomeMedicoVeterinario = "";
        this.ufCRMV = "";
        this.nroCRMV = null;
        this.sexoMedicoVeterinario = "";
        this.telefoneCelular = "";
        this.indAtivo = "";

        this.controlarExibicao(true, false);

        return ACTION_INPUT;
    }

    public String salvarMedicoVeterinario() {
        FacesContext salvarMedicoVeterinarioContext = FacesContext.getCurrentInstance();
        Integer linhasAfetadas = 0;

        if (this.validaDados()) {
            MedicosVeterinarios medicoVeterinarioFormulario = new MedicosVeterinarios(this.idMedicoVeterinario, this.nomeMedicoVeterinario, this.ufCRMV, this.nroCRMV, this.sexoMedicoVeterinario, this.telefoneCelular, this.indAtivo);

            try {
                if (this.idMedicoVeterinario == null) {
                    linhasAfetadas = medicosVeterinariosBO.inserirMedicoVeterinario(medicoVeterinarioFormulario);
                } else {
                    linhasAfetadas = medicosVeterinariosBO.atualizarMedicoVeterinario(medicoVeterinarioFormulario);
                }

                if (linhasAfetadas == 1) {
                    this.init();
                    salvarMedicoVeterinarioContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info:", "Médico Veterinário salvo com sucesso!"));
                }
            } catch (SavaBusinessException e) {
                salvarMedicoVeterinarioContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Não foi possível salvar o médico veterinário!"));
            }
        } else {
            salvarMedicoVeterinarioContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", this.getMensagemValidacao()));
        }

        return ACTION_INPUT;
    }

    private Boolean validaDados() {
        Boolean resultado = true;

        if ("".equals(this.nomeMedicoVeterinario) || this.nomeMedicoVeterinario.length() < 10) {
            this.setMensagemValidacao("Informe um nome válido!");
            resultado = false;
        } else if ("-1".equals(this.ufCRMV)) {
            this.setMensagemValidacao("Informe um UF de CRMV válido!");
            resultado = false;
        } else if (this.nroCRMV == null) {
            this.setMensagemValidacao("Informe um número de CRMV válido!");
            resultado = false;
        } else if ("-1".equals(this.sexoMedicoVeterinario)) {
            this.setMensagemValidacao("Informe um sexo válido!");
            resultado = false;
        } else if ("-1".equals(this.indAtivo)) {
            this.setMensagemValidacao("Informe uma situação válida!");
            resultado = false;
        }

        return resultado;
    }

    public String cancelar() {
        this.controlarExibicao(false, true);

        return ACTION_INPUT;
    }

    public String selecionarMedicoVeterinario(MedicosVeterinarios medicoVeterinario) {
        if (medicoVeterinario != null) {
            this.idMedicoVeterinario = medicoVeterinario.getIdMedicoVeterinario();
            this.nomeMedicoVeterinario = medicoVeterinario.getNomeMedicoVeterinario();
            this.ufCRMV = medicoVeterinario.getUfCRMV();
            this.nroCRMV = medicoVeterinario.getNroCRMV();
            this.sexoMedicoVeterinario = medicoVeterinario.getSexoMedicoVeterinario();
            this.telefoneCelular = medicoVeterinario.getTelefoneCelular();
            this.indAtivo = medicoVeterinario.getIndAtivo();

            this.controlarExibicao(true, false);
        }

        return ACTION_INPUT;
    }

    public String selecionarMedicoVeterinarioExclusao(MedicosVeterinarios medicoVeterinario) {
        if (medicoVeterinario != null) {
            this.idMedicoVeterinario = medicoVeterinario.getIdMedicoVeterinario();
            this.nomeMedicoVeterinario = medicoVeterinario.getNomeMedicoVeterinario();
        }

        return ACTION_INPUT;
    }

    public String excluirMedicoVeterinario() {
        FacesContext excluirMedicoVeterinarioContext = FacesContext.getCurrentInstance();
        Integer linhasAfetadas = 0;

        if (this.idMedicoVeterinario != null) {
            try {
                linhasAfetadas = medicosVeterinariosBO.excluirMedicoVeterinario(this.idMedicoVeterinario);

                if (linhasAfetadas == 1) {
                    this.init();
                    excluirMedicoVeterinarioContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info:", "Médico Veterinário excluído com sucesso!"));
                }
            } catch (SavaBusinessException e) {
                excluirMedicoVeterinarioContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", e.getMessage()));
            } finally {
                this.idMedicoVeterinario = null;
                this.nomeMedicoVeterinario = "";
            }
        }

        return ACTION_INPUT;
    }
}

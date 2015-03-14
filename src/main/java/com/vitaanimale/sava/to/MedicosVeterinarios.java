package com.vitaanimale.sava.to;

/**
 *
 * @author Elisa
 */
public class MedicosVeterinarios {
    
    private Integer idMedicoVeterinario;
    private String  nomeMedicoVeterinario;
    private String  ufCRMV;
    private Integer nroCRMV;
    private String  sexoMedicoVeterinario;
    private String  telefoneCelular;
    private String  indAtivo;

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

    public MedicosVeterinarios() {
        this.idMedicoVeterinario = null;
        this.nomeMedicoVeterinario = "";
        this.ufCRMV = "";
        this.nroCRMV = null;
        this.sexoMedicoVeterinario = "";
        this.telefoneCelular = "";
    }

    public MedicosVeterinarios(Integer idMedicoVeterinario, String nomeMedicoVeterinario, String ufCRMV, Integer nroCRMV, String sexoMedicoVeterinario, String telefoneCelular, String indAtivo) {
        this.idMedicoVeterinario = idMedicoVeterinario;
        this.nomeMedicoVeterinario = nomeMedicoVeterinario;
        this.ufCRMV = ufCRMV;
        this.nroCRMV = nroCRMV;
        this.sexoMedicoVeterinario = sexoMedicoVeterinario;
        this.telefoneCelular = telefoneCelular;
        this.indAtivo = indAtivo;
    }

    @Override
    public String toString() {
        return "MedicosVeterinarios{" + "idMedicoVeterinario=" + idMedicoVeterinario + ", nomeMedicoVeterinario=" + nomeMedicoVeterinario + ", ufCRMV=" + ufCRMV + ", nroCRMV=" + nroCRMV + ", sexoMedicoVeterinario=" + sexoMedicoVeterinario + ", telefoneCelular=" + telefoneCelular + ", indAtivo=" + indAtivo + '}';
    }
    
}

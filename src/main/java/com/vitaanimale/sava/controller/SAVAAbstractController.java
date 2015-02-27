package com.vitaanimale.sava.controller;

import javax.faces.context.FacesContext;

/**
 *
 * @author Elisa
 */
public class SAVAAbstractController {
    public final String ACTION_INPUT = "";
    private Boolean mostrarLista;
    private Boolean mostrarFormulario;
    private String  mensagemValidacao;
    FacesContext contextController = FacesContext.getCurrentInstance();

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

    public String getMensagemValidacao() {
        return mensagemValidacao;
    }

    public void setMensagemValidacao(String mensagemValidacao) {
        this.mensagemValidacao = mensagemValidacao;
    }
    
    public void controlarExibicao(Boolean bForm, Boolean bLista) {
        this.mostrarFormulario = bForm;
        this.mostrarLista = bLista;
    }
}

package com.vitaanimale.sava.controller;

/**
 *
 * @author Elisa
 */
public class SAVAController {
    public final String ACTION_INPUT = "";
    private Boolean mostrarLista;
    private Boolean mostrarFormulario;

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
    
    public void controlarExibicao(Boolean bForm, Boolean bLista) {
        this.mostrarFormulario = bForm;
        this.mostrarLista = bLista;
    }
}

package com.vitaanimale.sava.to;

/**
 *
 * @author Elisa
 */
public class Especies {
    private Integer idEspecie;
    private String  descricaoEspecie;

    public Integer getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(Integer idEspecie) {
        this.idEspecie = idEspecie;
    }

    public String getDescricaoEspecie() {
        return descricaoEspecie;
    }

    public void setDescricaoEspecie(String descricaoEspecie) {
        this.descricaoEspecie = descricaoEspecie;
    }

    public Especies() {
        this.idEspecie = null;
        this.descricaoEspecie = "";
    }

    public Especies(Integer idEspecie, String descricaoEspecie) {
        this.idEspecie = idEspecie;
        this.descricaoEspecie = descricaoEspecie;
    }

    @Override
    public String toString() {
        return "Especies{" + "idEspecie=" + idEspecie + ", descricaoEspecie=" + descricaoEspecie + '}';
    }  
    
}

package com.vitaanimale.sava.to;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Elisa
 */
public class Especies implements Serializable{
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.idEspecie);
        hash = 37 * hash + Objects.hashCode(this.descricaoEspecie);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Especies other = (Especies) obj;
        if (!Objects.equals(this.idEspecie, other.idEspecie)) {
            return false;
        }
        if (!Objects.equals(this.descricaoEspecie, other.descricaoEspecie)) {
            return false;
        }
        return true;
    }
    
    
}

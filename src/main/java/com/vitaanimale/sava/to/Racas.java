package com.vitaanimale.sava.to;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Elisa
 */
public class Racas implements Serializable{
    private Integer idRaca;
    private Integer idEspecie;
    private String  descricaoRaca;

    public Integer getIdRaca() {
        return idRaca;
    }

    public void setIdRaca(Integer idRaca) {
        this.idRaca = idRaca;
    }

    public Integer getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(Integer idEspecie) {
        this.idEspecie = idEspecie;
    }

    public String getDescricaoRaca() {
        return descricaoRaca;
    }

    public void setDescricaoRaca(String descricaoRaca) {
        this.descricaoRaca = descricaoRaca;
    }

    public Racas() {
        this.idRaca = null;
        this.idEspecie = null;
        this.descricaoRaca = "";
    }

    public Racas(Integer idRaca, Integer idEspecie, String descricaoRaca) {
        this.idRaca = idRaca;
        this.idEspecie = idEspecie;
        this.descricaoRaca = descricaoRaca;
    }

    @Override
    public String toString() {
        return "Racas{" + "idRaca=" + idRaca + ", idEspecie=" + idEspecie + ", descricaoRaca=" + descricaoRaca + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.idRaca);
        hash = 47 * hash + Objects.hashCode(this.idEspecie);
        hash = 47 * hash + Objects.hashCode(this.descricaoRaca);
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
        final Racas other = (Racas) obj;
        if (!Objects.equals(this.idRaca, other.idRaca)) {
            return false;
        }
        if (!Objects.equals(this.idEspecie, other.idEspecie)) {
            return false;
        }
        if (!Objects.equals(this.descricaoRaca, other.descricaoRaca)) {
            return false;
        }
        return true;
    }
   
    
}

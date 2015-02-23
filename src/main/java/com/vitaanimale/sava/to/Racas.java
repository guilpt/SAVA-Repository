package com.vitaanimale.sava.to;

/**
 *
 * @author Elisa
 */
public class Racas {
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
   
}

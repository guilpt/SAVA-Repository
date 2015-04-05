package com.vitaanimale.sava.to;

/**
 *
 * @author Elisa
 */
public class Servicos {
    private Integer idServico;
    private String  descricaoServico;
    private Double  valorVendaServico;

    public Integer getIdServico() {
        return idServico;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public Double getValorVendaServico() {
        return valorVendaServico;
    }

    public void setValorVendaServico(Double valorVendaServico) {
        this.valorVendaServico = valorVendaServico;
    }

    public Servicos() {
        this.idServico = null;
        this.descricaoServico = "";
        this.valorVendaServico = null;
    }
    
    public Servicos(Integer idServico, String descricaoServico, Double valorVendaServico) {
        this.idServico = idServico;
        this.descricaoServico = descricaoServico;
        this.valorVendaServico = valorVendaServico;
    }

    @Override
    public String toString() {
        return "Servicos{" + "idServico=" + idServico + ", descricaoServico=" + descricaoServico + ", valorVendaServico=" + valorVendaServico + '}';
    }
      
}

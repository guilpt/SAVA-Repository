package com.vitaanimale.sava.to;

/**
 *
 * @author Elisa
 */
public class Faturamentos {
    private Integer idFaturamento;
    private Integer idCliente;
    private String  dataFaturamento;
    private Double  valorTotal;

    public Integer getIdFaturamento() {
        return idFaturamento;
    }

    public void setIdFaturamento(Integer idFaturamento) {
        this.idFaturamento = idFaturamento;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getDataFaturamento() {
        return dataFaturamento;
    }

    public void setDataFaturamento(String dataFaturamento) {
        this.dataFaturamento = dataFaturamento;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Faturamentos() {
        this.idFaturamento = null;
        this.idCliente = null;
        this.dataFaturamento = "";
        this.valorTotal = null;
    }
    
    public Faturamentos(Integer idFaturamento, Integer idCliente, String dataFaturamento, Double valorTotal) {
        this.idFaturamento = idFaturamento;
        this.idCliente = idCliente;
        this.dataFaturamento = dataFaturamento;
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Faturamentos{" + "idFaturamento=" + idFaturamento + ", idCliente=" + idCliente + ", dataFaturamento=" + dataFaturamento + ", valorTotal=" + valorTotal + '}';
    }
    
}

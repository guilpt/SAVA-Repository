package com.vitaanimale.sava.to;

/**
 *
 * @author Elisa
 */
public class ItensProdutos {
    private Integer idItemProduto;
    private Integer idProduto;
    private String  codBarra;
    private Double  valorCompraProduto;
    private Double  valorVendaProduto;
    private String  dataEntrada;
    private String  dataSaida;
    private String  dataValidade;
    private Integer idDescricaoFaturamento;

    public Integer getIdItemProduto() {
        return idItemProduto;
    }

    public void setIdItemProduto(Integer idItemProduto) {
        this.idItemProduto = idItemProduto;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    public Double getValorCompraProduto() {
        return valorCompraProduto;
    }

    public void setValorCompraProduto(Double valorCompraProduto) {
        this.valorCompraProduto = valorCompraProduto;
    }

    public Double getValorVendaProduto() {
        return valorVendaProduto;
    }

    public void setValorVendaProduto(Double valorVendaProduto) {
        this.valorVendaProduto = valorVendaProduto;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Integer getIdDescricaoFaturamento() {
        return idDescricaoFaturamento;
    }

    public void setIdDescricaoFaturamento(Integer idDescricaoFaturamento) {
        this.idDescricaoFaturamento = idDescricaoFaturamento;
    }

    public ItensProdutos() {
        this.idItemProduto = null;
        this.idProduto = null;
        this.codBarra = "";
        this.valorCompraProduto = null;
        this.valorVendaProduto = null;
        this.dataEntrada = "";
        this.dataSaida = "";
        this.dataValidade = "";
        this.idDescricaoFaturamento = null;
    }
    
    public ItensProdutos(Integer idItemProduto, Integer idProduto, String codBarra, Double valorCompraProduto, Double valorVendaProduto, String dataEntrada, String dataSaida, String dataValidade, Integer idDescricaoFaturamento) {
        this.idItemProduto = idItemProduto;
        this.idProduto = idProduto;
        this.codBarra = codBarra;
        this.valorCompraProduto = valorCompraProduto;
        this.valorVendaProduto = valorVendaProduto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.dataValidade = dataValidade;
        this.idDescricaoFaturamento = idDescricaoFaturamento;
    }

    @Override
    public String toString() {
        return "ItensProdutos{" + "idItemProduto=" + idItemProduto + ", idProduto=" + idProduto + ", codBarra=" + codBarra + ", valorCompraProduto=" + valorCompraProduto + ", valorVendaProduto=" + valorVendaProduto + ", dataEntrada=" + dataEntrada + ", dataSaida=" + dataSaida + ", dataValidade=" + dataValidade + ", idDescricaoFaturamento=" + idDescricaoFaturamento + '}';
    }
    
}

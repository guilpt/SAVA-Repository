package com.vitaanimale.sava.to;

/**
 *
 * @author Elisa
 */
public class DescricaoFaturamentos {
    private Integer idDescricaoFaturamento;
    private Integer idServico;
    private Integer qtdServico;
    private Double  valorVendaServico;
    private Integer idProduto;
    private Integer qtdProduto;
    private Double  valorVendaProduto;

    public Integer getIdDescricaoFaturamento() {
        return idDescricaoFaturamento;
    }

    public void setIdDescricaoFaturamento(Integer idDescricaoFaturamento) {
        this.idDescricaoFaturamento = idDescricaoFaturamento;
    }

    public Integer getIdServico() {
        return idServico;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    public Integer getQtdServico() {
        return qtdServico;
    }

    public void setQtdServico(Integer qtdServico) {
        this.qtdServico = qtdServico;
    }

    public Double getValorVendaServico() {
        return valorVendaServico;
    }

    public void setValorVendaServico(Double valorVendaServico) {
        this.valorVendaServico = valorVendaServico;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(Integer qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public Double getValorVendaProduto() {
        return valorVendaProduto;
    }

    public void setValorVendaProduto(Double valorVendaProduto) {
        this.valorVendaProduto = valorVendaProduto;
    }

    public DescricaoFaturamentos() {
        this.idDescricaoFaturamento = null;
        this.idServico = null;
        this.qtdServico = null;
        this.valorVendaServico = null;
        this.idProduto = null;
        this.qtdProduto = null;
        this.valorVendaProduto = null;
    }
    
    public DescricaoFaturamentos(Integer idDescricaoFaturamento, Integer idServico, Integer qtdServico, Double valorVendaServico, Integer idProduto, Integer qtdProduto, Double valorVendaProduto) {
        this.idDescricaoFaturamento = idDescricaoFaturamento;
        this.idServico = idServico;
        this.qtdServico = qtdServico;
        this.valorVendaServico = valorVendaServico;
        this.idProduto = idProduto;
        this.qtdProduto = qtdProduto;
        this.valorVendaProduto = valorVendaProduto;
    }

    @Override
    public String toString() {
        return "DescricaoFaturamentos{" + "idDescricaoFaturamento=" + idDescricaoFaturamento + ", idServico=" + idServico + ", qtdServico=" + qtdServico + ", valorVendaServico=" + valorVendaServico + ", idProduto=" + idProduto + ", qtdProduto=" + qtdProduto + ", valorVendaProduto=" + valorVendaProduto + '}';
    }
    
}

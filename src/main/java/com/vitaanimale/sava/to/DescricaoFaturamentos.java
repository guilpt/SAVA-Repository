package com.vitaanimale.sava.to;

/**
 *
 * @author Elisa
 */
public class DescricaoFaturamentos {
    private Integer idDescricaoFaturamento;
    private Integer idFaturamento;
    private String  tipoDescricaoFaturamento;
    private Integer idServico;
    private Integer qtdServico;
    private Double  valorVendaServico;
    private Integer idProduto;
    private Integer qtdProduto;
    private Double  valorVendaProduto;
    private Integer id;
    private String  descricao;
    private Integer qtd;
    private Double  valorVenda;

    public Integer getIdDescricaoFaturamento() {
        return idDescricaoFaturamento;
    }

    public void setIdDescricaoFaturamento(Integer idDescricaoFaturamento) {
        this.idDescricaoFaturamento = idDescricaoFaturamento;
    }

    public Integer getIdFaturamento() {
        return idFaturamento;
    }

    public void setIdFaturamento(Integer idFaturamento) {
        this.idFaturamento = idFaturamento;
    }

    public String getTipoDescricaoFaturamento() {
        return tipoDescricaoFaturamento;
    }

    public void setTipoDescricaoFaturamento(String tipoDescricaoFaturamento) {
        this.tipoDescricaoFaturamento = tipoDescricaoFaturamento;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public DescricaoFaturamentos() {
        this.idDescricaoFaturamento = null;
        this.idFaturamento = null;
        this.tipoDescricaoFaturamento = null;
        this.idServico = null;
        this.qtdServico = null;
        this.valorVendaServico = null;
        this.idProduto = null;
        this.qtdProduto = null;
        this.valorVendaProduto = null;
        this.id = null;
        this.descricao = "";
        this.qtd = null;
        this.valorVenda = null;
    }
    
    public DescricaoFaturamentos(Integer idDescricaoFaturamento, Integer idFaturamento, Integer idServico, Integer qtdServico, Double valorVendaServico, Integer idProduto, Integer qtdProduto, Double valorVendaProduto) {
        this.idDescricaoFaturamento = idDescricaoFaturamento;
        this.idFaturamento = idFaturamento;
        this.idServico = idServico;
        this.qtdServico = qtdServico;
        this.valorVendaServico = valorVendaServico;
        this.idProduto = idProduto;
        this.qtdProduto = qtdProduto;
        this.valorVendaProduto = valorVendaProduto;
    }

    @Override
    public String toString() {
        return "DescricaoFaturamentos{" + "idDescricaoFaturamento=" + idDescricaoFaturamento + ", idFaturamento=" + idFaturamento + ", tipoDescricaoFaturamento=" + tipoDescricaoFaturamento + ", idServico=" + idServico + ", qtdServico=" + qtdServico + ", valorVendaServico=" + valorVendaServico + ", idProduto=" + idProduto + ", qtdProduto=" + qtdProduto + ", valorVendaProduto=" + valorVendaProduto + ", id=" + id + ", descricao=" + descricao + ", qtd=" + qtd + ", valorVenda=" + valorVenda + '}';
    }

}

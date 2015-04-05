package com.vitaanimale.sava.to;

/**
 *
 * @author Elisa
 */
public class Produtos {
    private Integer idProduto;
    private Integer idFornecedor;
    private String  nomeFornecedor;
    private Integer idTipoProduto;
    private String  marca;
    private String  descricaoProduto;
    private Double  valorCompraProduto;
    private Double  valorVendaProduto;

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public Integer getIdTipoProduto() {
        return idTipoProduto;
    }

    public void setIdTipoProduto(Integer idTipoProduto) {
        this.idTipoProduto = idTipoProduto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
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

    public Produtos() {
        this.idProduto = null;
        this.idFornecedor = null;
        this.nomeFornecedor = null;
        this.idTipoProduto = null;
        this.marca = "";
        this.descricaoProduto = "";
        this.valorCompraProduto = null;
        this.valorVendaProduto = null;
    }
    
    public Produtos(Integer idProduto, Integer idFornecedor, String nomeFornecedor, Integer idTipoProduto, String marca, String descricaoProduto, Double valorCompraProduto, Double valorVendaProduto) {
        this.idProduto = idProduto;
        this.idFornecedor = idFornecedor;
        this.nomeFornecedor = nomeFornecedor;
        this.idTipoProduto = idTipoProduto;
        this.marca = marca;
        this.descricaoProduto = descricaoProduto;
        this.valorCompraProduto = valorCompraProduto;
        this.valorVendaProduto = valorVendaProduto;
    }

    @Override
    public String toString() {
        return "Produtos{" + "idProduto=" + idProduto + ", idFornecedor=" + idFornecedor + ", nomeFornecedor=" + nomeFornecedor + ", idTipoProduto=" + idTipoProduto + ", marca=" + marca + ", descricaoProduto=" + descricaoProduto + ", valorCompraProduto=" + valorCompraProduto + ", valorVendaProduto=" + valorVendaProduto + '}';
    }
    
}

package com.vitaanimale.sava.to;

/**
 *
 * @author Elisa
 */
public class TiposProdutos {
    private Integer idTipoProduto;
    private String  descricaoTipoProduto;

    public Integer getIdTipoProduto() {
        return idTipoProduto;
    }

    public void setIdTipoProduto(Integer idTipoProduto) {
        this.idTipoProduto = idTipoProduto;
    }

    public String getDescricaoTipoProduto() {
        return descricaoTipoProduto;
    }

    public void setDescricaoTipoProduto(String descricaoTipoProduto) {
        this.descricaoTipoProduto = descricaoTipoProduto;
    }

    public TiposProdutos() {
        this.idTipoProduto = null;
        this.descricaoTipoProduto = "";
    }
    
    public TiposProdutos(Integer idTipoProduto, String descricaoTipoProduto) {
        this.idTipoProduto = idTipoProduto;
        this.descricaoTipoProduto = descricaoTipoProduto;
    }

    @Override
    public String toString() {
        return "TiposProdutos{" + "idTipoProduto=" + idTipoProduto + ", descricaoTipoProduto=" + descricaoTipoProduto + '}';
    }
    
}

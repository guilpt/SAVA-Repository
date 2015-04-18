package com.vitaanimale.sava.to;

/**
 *
 * @author Elisa
 */
public class TiposPagamentos {
    private Integer idTipoPagamento;
    private String  descricaoTipoPagamento;

    public Integer getIdTipoPagamento() {
        return idTipoPagamento;
    }

    public void setIdTipoPagamento(Integer idTipoPagamento) {
        this.idTipoPagamento = idTipoPagamento;
    }

    public String getDescricaoTipoPagamento() {
        return descricaoTipoPagamento;
    }

    public void setDescricaoTipoPagamento(String descricaoTipoPagamento) {
        this.descricaoTipoPagamento = descricaoTipoPagamento;
    }

    public TiposPagamentos() {
        this.idTipoPagamento = null;
        this.descricaoTipoPagamento = "";
    }
    
    public TiposPagamentos(Integer idTipoPagamento, String descricaoTipoPagamento) {
        this.idTipoPagamento = idTipoPagamento;
        this.descricaoTipoPagamento = descricaoTipoPagamento;
    }

    @Override
    public String toString() {
        return "TiposPagamentos{" + "idTipoPagamento=" + idTipoPagamento + ", descricaoTipoPagamento=" + descricaoTipoPagamento + '}';
    }
}

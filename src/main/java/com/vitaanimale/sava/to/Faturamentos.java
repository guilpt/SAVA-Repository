package com.vitaanimale.sava.to;

/**
 *
 * @author Elisa
 */
public class Faturamentos {
    private Integer idFaturamento;
    private Integer idMedicoVeterinario;
    private Integer idCliente;
    private Integer idAnimal;
    private String  dataFaturamento;
    private Double  valorTotal;
    private Integer idTipoPagamento;
    private String  descricaoTipoPagamento;
    private String  recebido;
    private String  recebidoExtenso;
    private String  obsPagamento;

    public Integer getIdFaturamento() {
        return idFaturamento;
    }

    public void setIdFaturamento(Integer idFaturamento) {
        this.idFaturamento = idFaturamento;
    }

    public Integer getIdMedicoVeterinario() {
        return idMedicoVeterinario;
    }

    public void setIdMedicoVeterinario(Integer idMedicoVeterinario) {
        this.idMedicoVeterinario = idMedicoVeterinario;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
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

    public String getRecebido() {
        return recebido;
    }

    public void setRecebido(String recebido) {
        this.recebido = recebido;
    }

    public String getRecebidoExtenso() {
        return recebidoExtenso;
    }

    public void setRecebidoExtenso(String recebidoExtenso) {
        this.recebidoExtenso = recebidoExtenso;
    }

    public String getObsPagamento() {
        return obsPagamento;
    }

    public void setObsPagamento(String obsPagamento) {
        this.obsPagamento = obsPagamento;
    }

    public Faturamentos() {
        this.idFaturamento = null;
        this.idMedicoVeterinario = null;
        this.idCliente = null;
        this.idAnimal = null;
        this.dataFaturamento = "";
        this.valorTotal = null;
        this.idTipoPagamento = null;
        this.recebido = "";
        this.obsPagamento = "";
    }
    
    public Faturamentos(Integer idFaturamento, Integer idMedicoVeterinario, Integer idCliente, Integer idAnimal, String dataFaturamento, Double valorTotal, Integer idTipoPagemento, String recebido, String obsPagamento) {
        this.idFaturamento = idFaturamento;
        this.idMedicoVeterinario = idMedicoVeterinario;
        this.idCliente = idCliente;
        this.idAnimal = idAnimal;
        this.dataFaturamento = dataFaturamento;
        this.valorTotal = valorTotal;
        this.idTipoPagamento = idTipoPagemento;
        this.recebido = recebido;
        this.obsPagamento = obsPagamento;
    }

    @Override
    public String toString() {
        return "Faturamentos{" + "idFaturamento=" + idFaturamento + ", idMedicoVeterinario=" + idMedicoVeterinario + ", idCliente=" + idCliente + ", idAnimal=" + idAnimal + ", dataFaturamento=" + dataFaturamento + ", valorTotal=" + valorTotal + ", idTipoPagamento=" + idTipoPagamento + ", descricaoTipoPagamento=" + descricaoTipoPagamento + ", recebido=" + recebido + ", recebidoExtenso=" + recebidoExtenso + ", obsPagamento=" + obsPagamento + '}';
    }
}

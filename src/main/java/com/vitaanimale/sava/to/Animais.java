package com.vitaanimale.sava.to;

/**
 *
 * @author Elisa
 */
public class Animais {
    
    private Integer idAnimal;
    private Integer idCliente;
    private String  especie;
    private String  raca;
    private String  nomeAnimal;
    private String  sexoAnimal;
    private String  corPelagem;
    private Integer idadeAno;
    private Integer idadeMes;
    private Double  peso;
    private String  obito;
    private String  disponibilidadeCruzamento;

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public String getSexoAnimal() {
        return sexoAnimal;
    }

    public void setSexoAnimal(String sexoAnimal) {
        this.sexoAnimal = sexoAnimal;
    }

    public String getCorPelagem() {
        return corPelagem;
    }

    public void setCorPelagem(String corPelagem) {
        this.corPelagem = corPelagem;
    }

    public Integer getIdadeAno() {
        return idadeAno;
    }

    public void setIdadeAno(Integer idadeAno) {
        this.idadeAno = idadeAno;
    }

    public Integer getIdadeMes() {
        return idadeMes;
    }

    public void setIdadeMes(Integer idadeMes) {
        this.idadeMes = idadeMes;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getObito() {
        return obito;
    }

    public void setObito(String obito) {
        this.obito = obito;
    }

    public String getDisponibilidadeCruzamento() {
        return disponibilidadeCruzamento;
    }

    public void setDisponibilidadeCruzamento(String disponibilidadeCruzamento) {
        this.disponibilidadeCruzamento = disponibilidadeCruzamento;
    }

    public Animais() {
        this.idAnimal = null;
        this.idCliente = null;
        this.especie = "";
        this.raca = "";
        this.nomeAnimal = "";
        this.sexoAnimal = "";
        this.corPelagem = "";
        this.idadeAno = null;
        this.idadeMes = null;
        this.peso = null;
        this.obito = "";
        this.disponibilidadeCruzamento = "";
    }

    public Animais(Integer idAnimal, Integer idCliente, String especie, String raca, String nomeAnimal, String sexoAnimal, String corPelagem, Integer idadeAno, Integer idadeMes, Double peso, String obito, String disponibilidadeCruzamento) {
        this.idAnimal = idAnimal;
        this.idCliente = idCliente;
        this.especie = especie;
        this.raca = raca;
        this.nomeAnimal = nomeAnimal;
        this.sexoAnimal = sexoAnimal;
        this.corPelagem = corPelagem;
        this.idadeAno = idadeAno;
        this.idadeMes = idadeMes;
        this.peso = peso;
        this.obito = obito;
        this.disponibilidadeCruzamento = disponibilidadeCruzamento;
    }

    @Override
    public String toString() {
        return "Animais{" + "idAnimal=" + idAnimal + ", idCliente=" + idCliente + ", especie=" + especie + ", raca=" + raca + ", nomeAnimal=" + nomeAnimal + ", sexoAnimal=" + sexoAnimal + ", corPelagem=" + corPelagem + ", idadeAno=" + idadeAno + ", idadeMes=" + idadeMes + ", peso=" + peso + ", obito=" + obito + ", disponibilidadeCruzamento=" + disponibilidadeCruzamento + '}';
    }
    
    
    
}

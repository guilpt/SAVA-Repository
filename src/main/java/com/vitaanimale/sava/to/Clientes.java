package com.vitaanimale.sava.to;

/**
 *
 * @author Elisa
 */
public class Clientes {

    private Integer idCliente;
    private String  nomeCliente;
    private String  cpf;
    private String  sexo;
    private String  dataNascimento;
    private String  endereco;
    private String  telefoneResidencial;
    private String  telefoneCelular;
    private String  email;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Clientes() {
        this.idCliente = null;
        this.nomeCliente = "";
        this.cpf = "";
        this.sexo = "";
        this.dataNascimento = "";
        this.endereco = "";
        this.telefoneResidencial = "";
        this.telefoneCelular = "";
        this.email = "";
    }

    public Clientes(Integer idCliente, String nomeCliente, String cpf, String sexo, String dataNascimento, String endereco, String telefoneResidencial, String telefoneCelular, String email) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefoneResidencial = telefoneResidencial;
        this.telefoneCelular = telefoneCelular;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Clientes{" + "idCliente=" + idCliente + ", nomeCliente=" + nomeCliente + ", cpf=" + cpf + ", sexo=" + sexo + ", dataNascimento=" + dataNascimento + ", endereco=" + endereco + ", telefoneResidencial=" + telefoneResidencial + ", telefoneCelular=" + telefoneCelular + ", email=" + email + '}';
    }
}

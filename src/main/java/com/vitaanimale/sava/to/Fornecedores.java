package com.vitaanimale.sava.to;

/**
 *
 * @author Elisa
 */
public class Fornecedores {
    
    private Integer idFornecedor;
    private String  nomeFornecedor;
    private String  cnpj;
    private String  telefoneComercial;
    private String  emailFornecedor;

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefoneComercial() {
        return telefoneComercial;
    }

    public void setTelefoneComercial(String telefoneComercial) {
        this.telefoneComercial = telefoneComercial;
    }

    public String getEmailFornecedor() {
        return emailFornecedor;
    }

    public void setEmailFornecedor(String emailFornecedor) {
        this.emailFornecedor = emailFornecedor;
    }

    public Fornecedores() {
        this.idFornecedor = null;
        this.nomeFornecedor = "";
        this.cnpj = "";
        this.telefoneComercial = "";
        this.emailFornecedor = "";
    }
    
    public Fornecedores(Integer idFornecedor, String nomeFornecedor, String cnpj, String telefoneComercial, String emailFornecedor) {
        this.idFornecedor = idFornecedor;
        this.nomeFornecedor = nomeFornecedor;
        this.cnpj = cnpj;
        this.telefoneComercial = telefoneComercial;
        this.emailFornecedor = emailFornecedor;
    }

    @Override
    public String toString() {
        return "Fornecedores{" + "idFornecedor=" + idFornecedor + ", nomeFornecedor=" + nomeFornecedor + ", cnpj=" + cnpj + ", telefoneComercial=" + telefoneComercial + ", emailFornecedor=" + emailFornecedor + '}';
    }
    
}

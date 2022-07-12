/*
 */
package model.bean.pessoa;

public class Fornecedor extends Pessoa {

    private String cnpj;
    private String telefone;
    private String email;
    private Endereco endereco;

    //--------------------------------------------------
    public Fornecedor() {
    }

    public Fornecedor(String nome, String cnpj, String telefone, String email, Endereco endereco) {
        super(nome);
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public Fornecedor(int id, String nome, String cnpj, String telefone, String email, Endereco endereco) {
        super(id, nome);
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    //--------------------------------------------------
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

} // fim class

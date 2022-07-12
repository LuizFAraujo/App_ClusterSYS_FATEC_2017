/*
 */
package model.bean.pessoa;

public class Cliente extends Pessoa {

    private String cpf;
    private String telefone;
    private String email;
    private Endereco endereco;

    //--------------------------------------------------
    public Cliente() {
    }

    public Cliente(String nome, String cpf, String telefone, String email, Endereco endereco) {
        super(nome);
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public Cliente(int id, String nome, String cpf, String telefone, String email, Endereco endereco) {
        super(id, nome);
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    //--------------------------------------------------
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

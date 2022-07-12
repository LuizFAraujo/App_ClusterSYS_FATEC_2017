/**/
package model.bean;

public class Produto {

    private int id;
    private String nome;
    private String categoria;
    private double preco;
    private int id_fornecedor;

    //--------------------------------------------------
    public Produto() {
    }

    public Produto(String nome, String categoria, double preco, int id_fornecedor) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.id_fornecedor = id_fornecedor;
    }

    public Produto(int id, String nome, String categoria, double preco, int id_fornecedor) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.id_fornecedor = id_fornecedor;
    }

    //--------------------------------------------------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

}

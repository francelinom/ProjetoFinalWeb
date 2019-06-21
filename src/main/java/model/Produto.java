
package model;


public class Produto {
    private String nome_produto;
    private double preco_produto;
    private int qtd_produto;

    public Produto() {
    }

    public Produto(String nome_produto, double preco_produto, int qtd_produto) {
        this.nome_produto = nome_produto;
        this.preco_produto = preco_produto;
        this.qtd_produto = qtd_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public double getPreco_produto() {
        return preco_produto;
    }

    public void setPreco_produto(double preco_produto) {
        this.preco_produto = preco_produto;
    }

    public int getQtd_produto() {
        return qtd_produto;
    }

    public void setQtd_produto(int qtd_produto) {
        this.qtd_produto = qtd_produto;
    }
    
    
    
}

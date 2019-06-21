
package model;


public class Estoque {
    private Integer id_produto;
    private String descricao_produto;
    private double preco_produto;
    private int qtd_produto;

    public Estoque() {
    }

    public Estoque(Integer id_produto, String descricao_produto, double preco_produto, int qtd_produto) {
        this.id_produto = id_produto;
        this.descricao_produto = descricao_produto;
        this.preco_produto = preco_produto;
        this.qtd_produto = qtd_produto;
    }

    public Integer getId_produto() {
        return id_produto;
    }

    public void setId_produto(Integer id_produto) {
        this.id_produto = id_produto;
    }

    public String getDescricao_produto() {
        return descricao_produto;
    }

    public void setDescricao_produto(String descricao_produto) {
        this.descricao_produto = descricao_produto;
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

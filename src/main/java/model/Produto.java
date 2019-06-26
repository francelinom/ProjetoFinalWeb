package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 3959599853587681168L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private int id_produto;

    private String nome_produto;

    private double preco_produto;

    private int qtd_produto;
    
    public Produto() {
    }

    /**
     * **********************************************************
     * MUITOS PARA MUITOS CASO 2
     * *********************************************************
     */
    @ManyToMany(mappedBy = "produtos")
    private List<Estoque> estoque = new ArrayList<>();

    public List<Estoque> getEstoque() {
        return estoque;
    }

    public void setEstoque(List<Estoque> estoque) {
        this.estoque = estoque;
    }

    /**
     * **********************************************************
     * MUITOS PARA MUITOS CASO 2
     * *********************************************************
     */
    @ManyToMany(mappedBy = "produtos")
    private List<Venda> venda = new ArrayList<>();

    public List<Venda> getVenda() {
        return venda;
    }

    public void setVenda(List<Venda> venda) {
        this.venda = venda;
    }

   
   

    public Produto(String nome_produto, double preco_produto) {
        this.nome_produto = nome_produto;
        this.preco_produto = preco_produto;
        //this.qtd_produto = qtd_produto;
    }

    public Produto(int id_produto, String nome_produto, double preco_produto) {
        this.id_produto = id_produto;
        this.nome_produto = nome_produto;
        this.preco_produto = preco_produto;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
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

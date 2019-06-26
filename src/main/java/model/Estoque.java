package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
@Entity
@Table(name = "estoque")
public class Estoque implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estoque")
    private Integer id_estoque;
    private String nome_estoque;
    //private int qtd_produto;
    //private Date hora_entrada;
    //private Date hora_saida;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "estoque_produtos",
        joinColumns = {
        @JoinColumn(name = "estoque_id",
                referencedColumnName = "id_estoque")}, inverseJoinColumns = {
        @JoinColumn(name = "produto_id")})
    private List<Produto> produtos = new ArrayList<>();

    

    /**
     * **********************************************************
     * MUITOS PARA MUITOS CASO 2
     * *********************************************************
     */
    public void addProduto(Produto nProduto) {
        produtos.add(nProduto);
        nProduto.getEstoque().add(this);
    }

    public void removeProduto(Produto nProduto) {
        produtos.remove(nProduto);
        nProduto.getEstoque().remove(this);
    }
    //* **********************************************************

    public Estoque() {
    }

    public Estoque(Integer id_estoque, String nome_estoque) {
        this.id_estoque = id_estoque;
        this.nome_estoque = nome_estoque;
    }

    public Integer getId_estoque() {
        return id_estoque;
    }

    public void setId_estoque(Integer id_estoque) {
        this.id_estoque = id_estoque;
    }

    public String getNome_estoque() {
        return nome_estoque;
    }

    public void setNome_estoque(String nome_estoque) {
        this.nome_estoque = nome_estoque;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    

    

}

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
    @Column(name = "id_produto")
    private Integer id_produto;
    private String descricao_produto;
    private int qtd_produto;
    private Date hora_entrada;
    private Date hora_saida;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "estoque_produtos", joinColumns = {
        @JoinColumn(name = "estoque_id",
                referencedColumnName = "id_produto")}, inverseJoinColumns = {
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

    public Estoque(Integer id_produto, String descricao_produto, int qtd_produto, Date hora_entrada, Date hora_saida) {
        this.id_produto = id_produto;
        this.descricao_produto = descricao_produto;
        this.qtd_produto = qtd_produto;
        this.hora_entrada = hora_entrada;
        this.hora_saida = hora_saida;
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

    public int getQtd_produto() {
        return qtd_produto;
    }

    public void setQtd_produto(int qtd_produto) {
        this.qtd_produto = qtd_produto;
    }

    public Date getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(Date hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public Date getHora_saida() {
        return hora_saida;
    }

    public void setHora_saida(Date hora_saida) {
        this.hora_saida = hora_saida;
    }

}

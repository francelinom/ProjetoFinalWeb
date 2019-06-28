package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static java.util.Objects.hash;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "venda")
public class Venda implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda")
    private int id_venda;
    private float preco_venda;
    private Date data_venda;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "venda_produtos", joinColumns = {
        @JoinColumn(name = "venda_id",
                referencedColumnName = "id_venda")}, inverseJoinColumns = {
        @JoinColumn(name = "produto_id")})
    private List<Produto> produtos = new ArrayList<>();

    /**
     * **********************************************************
     * MUITOS PARA MUITOS CASO 2
     * *********************************************************
     */
    public void addProduto(Produto nProduto) {
        produtos.add(nProduto);
        nProduto.getVenda().add(this);
    }

    public void removeProduto(Produto nProduto) {
        produtos.remove(nProduto);
        nProduto.getVenda().remove(this);
    }
    //* **********************************************************

    
    /**
     * **********************************************************
     * UM PARA MUITOS - CASO 3
     * **********************************************************
     */
    @ManyToOne
    @JoinColumn(name = "usuario_id")

    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    /**
     * **********************************************************
     */
    
    
    public Venda() {
    }

    public Venda(int id_venda, float preco_venda, Date data_venda) {
        this.id_venda = id_venda;
        this.preco_venda = preco_venda;
        this.data_venda = data_venda;
    }

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public float getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(float preco_venda) {
        this.preco_venda = preco_venda;
    }

    public Date getData_venda() {
        return data_venda;
    }

    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }
    
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    
}

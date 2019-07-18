package bean;

import dao.ProdutoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Produto;

@ManagedBean
@SessionScoped
public class CarrinhoBean {

    private float valor = 0;
    private int qtdCesta = 0;
    private int qtd = 0;
    
    ProdutoDAO produtoDao = new ProdutoDAO();

    private List<Produto> carrinho = new ArrayList<>();
    private Produto produto = new Produto();

    public CarrinhoBean() {
    }
    
    
     public String adicionarCarrinho(Produto p) {
        p.setQtd_produto(1);
         carrinho.add(p);
        
        return "/user/LojaVirtual?faces-redirect=true";
    }

    public String removerCarrinho(Produto p) {
        
        carrinho.remove(p);
        
        return "/user/BemVindo.xhtml";
    }
    

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getQtdCesta() {
        return qtdCesta;
    }

    public void setQtdCesta(int qtdCesta) {
        this.qtdCesta = qtdCesta;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public ProdutoDAO getProdutoDao() {
        return produtoDao;
    }

    public void setProdutoDao(ProdutoDAO produtoDao) {
        this.produtoDao = produtoDao;
    }

    public List<Produto> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(List<Produto> carrinho) {
        this.carrinho = carrinho;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
   
   
}

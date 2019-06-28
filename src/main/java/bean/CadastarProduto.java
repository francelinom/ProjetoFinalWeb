
package bean;

import dao.EstoqueDAO;
import dao.ProdutoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Estoque;
import model.Produto;

@ManagedBean
@SessionScoped
public class CadastarProduto {
    private List<Produto> listaProduto;
    ProdutoDAO daoProduto;
    private Produto produto;  
    
    public void inicializar(){
        listaProduto = new ArrayList<>();
        daoProduto = new ProdutoDAO(); //preparando dao Estoque
        produto = new Produto();
        
        listaProduto = daoProduto.listAll();
    }
    public CadastarProduto() {
    }

    public CadastarProduto(List<Produto> listaProduto, ProdutoDAO daoProduto, Produto produto) {
        this.listaProduto = listaProduto;
        this.daoProduto = daoProduto;
        this.produto = produto;
    }
    
    
    public void cadastrar() {
        daoProduto = new ProdutoDAO();
        daoProduto.save(produto); //adiciona o Produto no banco               
        
        produto = new Produto();//limpar os campos
        
    }
    public String enviarProduto(Produto p) {
        produto = p;
        
        return "/admin/AddEstoque.xhtml";
        
    }
    
     public String excluirProduto(Produto e){
        daoProduto = new ProdutoDAO();
        daoProduto.delete(e);
        
        return "/admin/BemVindo.xhtml";
    }
    
    public String editarProduto(Produto e){
        produto = e;
        
        return "/admin/editarProduto.xhtml";
    }
    public String salvar(){
        
        daoProduto = new ProdutoDAO();
        daoProduto.save(produto);
        
       
        return "/admin/BemVindo.xhtml";
    }

    public String cancelar(){
        produto = new Produto();
       
        return "/admin/BemVindo.xhtml";
    }
    
    
    public List<Produto> produtoList(){
        daoProduto = new ProdutoDAO();
        listaProduto = daoProduto.listAll();
        return listaProduto;
    }
    
    public String addProdutoEstoque(Produto add){
        produto = add;
        
        return "/admin/addEstoque.xhtml";
    }
    
    public List<Produto> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(List<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }

    public ProdutoDAO getDaoProduto() {
        return daoProduto;
    }

    public void setDaoProduto(ProdutoDAO daoProduto) {
        this.daoProduto = daoProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
    /*private List<Estoque> listaEstoque; 
    EstoqueDAO daoEstoque;
    private Estoque estoque;
    

    public void inicializar(){
        listaEstoque= new ArrayList<>();
        daoEstoque = new EstoqueDAO(); //preparando dao Estoque
        estoque = new Estoque();
        
        listaEstoque = daoEstoque.listAll();
    }
    public CadastarProduto() {
    }
    
   
    public void cadastrar() {
        daoEstoque = new EstoqueDAO();
        daoEstoque.save(estoque); //adiciona o usuario no banco               
        ProdutoDAO produtoDao = new ProdutoDAO();
        
       // estoque.addProduto();
        
        estoque = new Estoque();//limpar os campos
        
    }
    
     public String excluirEstoque(Estoque e){
        daoEstoque = new EstoqueDAO();
        daoEstoque.delete(e);
        
        return "/admin/BemVindo.xhtml";
    }
    
    public String editarEstoque(Estoque e){
        estoque = e;
        
        return "/admin/editarProduto.xhtml";
    }
    public String salvar(){
        daoEstoque = new EstoqueDAO();
        daoEstoque.save(estoque);
        
       
        return "/admin/BemVindo.xhtml";
    }

    public String cancelar(){
        estoque = new Estoque();
       
        return "/admin/BemVindo.xhtml";
    }
    
    
    public List<Estoque> estoqueList(){
        daoEstoque = new EstoqueDAO();
        listaEstoque = daoEstoque.listAll();
        return listaEstoque;
    }

    public EstoqueDAO getDaoEstoque() {
        return daoEstoque;
    }

    public void setDaoEstoque(EstoqueDAO daoEstoque) {
        this.daoEstoque = daoEstoque;
    }
    
    
    

    public List<Estoque> getListaEstoque() {
        return listaEstoque;
    }

    public void setListaEstoque(List<Estoque> listaEstoque) {
        this.listaEstoque = listaEstoque;
    }
    
    
    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
    */

    

    
}

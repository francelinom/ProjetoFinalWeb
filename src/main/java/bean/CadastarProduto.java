
package bean;

import dao.EstoqueDAO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Estoque;

@ManagedBean
@SessionScoped
public class CadastarProduto {
    private List<Estoque> listaEstoque; 
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
    
    
}

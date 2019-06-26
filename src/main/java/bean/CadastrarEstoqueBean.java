
package bean;

import dao.EstoqueDAO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Estoque;

@ManagedBean
@SessionScoped
public class CadastrarEstoqueBean {
    private List<Estoque> listaEstoque;
    EstoqueDAO daoEstoque;
    private Estoque estoque;

    public CadastrarEstoqueBean() {
    }

    public CadastrarEstoqueBean(List<Estoque> listaEstoque, EstoqueDAO daoEstoque, Estoque estoque) {
        this.listaEstoque = listaEstoque;
        this.daoEstoque = daoEstoque;
        this.estoque = estoque;
    }
    
    public void inicializarEstoque(){
        listaEstoque = new ArrayList<>();
        daoEstoque = new EstoqueDAO(); //preparando dao Estoque
        estoque = new Estoque();
        
        listaEstoque = daoEstoque.listAll();
    }
    
    public void cadastrarEstoque() {
        daoEstoque = new EstoqueDAO();
        daoEstoque.save(estoque); //adiciona o Produto no banco               
        
        estoque = new Estoque();//limpar os campos
        
    }
    
    public String cancelarEstoque(){
        estoque = new Estoque();
       
        return "/admin/BemVindo.xhtml";
    }
    
    public List<Estoque> estoqueList(){
        daoEstoque = new EstoqueDAO();
        listaEstoque = daoEstoque.listAll();
        return listaEstoque;
    }
    

    public List<Estoque> getListaEstoque() {
        return listaEstoque;
    }

    public void setListaEstoque(List<Estoque> listaEstoque) {
        this.listaEstoque = listaEstoque;
    }

    public EstoqueDAO getDaoEstoque() {
        return daoEstoque;
    }

    public void setDaoEstoque(EstoqueDAO daoEstoque) {
        this.daoEstoque = daoEstoque;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
    
    
}

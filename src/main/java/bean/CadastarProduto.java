
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
    private List<Estoque> listaEstoque = new ArrayList<>();
    EstoqueDAO daoEstoque = new EstoqueDAO(); //preparando dao Estoque
    private Estoque estoque = new Estoque();
    

    public CadastarProduto() {
    }
    
   
    public void cadastrar() {
        EstoqueDAO daoEstoque = new EstoqueDAO(); //preparando dao usuario
        daoEstoque.save(estoque); //adiciona o usuario no banco               

        estoque = new Estoque();//limpar os campos
        
    }
    
    public List<Estoque> estoqueList(){
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

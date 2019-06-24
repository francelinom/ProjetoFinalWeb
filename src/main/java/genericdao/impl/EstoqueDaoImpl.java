
package genericdao.impl;

import genericdao.interfaces.IGenericEstoque;
import model.Estoque;


public class EstoqueDaoImpl extends GenericDaoImpl<Estoque, Integer> implements IGenericEstoque{

    public EstoqueDaoImpl() {
        super (Estoque.class);
    }
    
    
    
}

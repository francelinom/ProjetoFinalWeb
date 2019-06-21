
package genericdao.impl;

import genericdao.interfaces.IGenericProduto;
import java.io.Serializable;
import model.Produto;

public class ProdutoDaoImpl extends GenericDaoImpl<Produto, Integer> implements IGenericProduto{

    public ProdutoDaoImpl() {
        super (Produto.class);
    }

    
 
}


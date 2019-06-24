
package genericdao.impl;

import genericdao.interfaces.IGenericUsuario;
import model.Usuario;

public class UsuarioDaoImpl extends GenericDaoImpl<Usuario, Integer> implements IGenericUsuario{

    public UsuarioDaoImpl() {
        super(Usuario.class);
    }
    
}

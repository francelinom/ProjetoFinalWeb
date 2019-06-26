package dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistencia.HibernateUtil;

public class UsuarioDAO {

    private Session session = null;

    public UsuarioDAO() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    public Usuario findById(Integer id) {
        Usuario object = (Usuario) session.get(Usuario.class, id);
        return object;
    }

    public void save(Usuario object) {
        Transaction u = session.beginTransaction();
        session.saveOrUpdate((Usuario) object);
        u.commit();
    }

    public void delete(Usuario object) {
        Transaction u = session.beginTransaction();
        session.delete((Usuario) object);
        u.commit();
    }

    public List<Usuario> listAll() {

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Usuario> query = builder.createQuery(Usuario.class);

        Root<Usuario> klassRoot = query.from(Usuario.class);

        query.select(klassRoot);

        List<Usuario> result = session.createQuery(query).getResultList();
        session.close();
        return result;

    }

}

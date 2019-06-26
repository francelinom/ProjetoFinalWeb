
package dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Estoque;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistencia.HibernateUtil;


public class EstoqueDAO {
    private Session session = null;

    public EstoqueDAO() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }
    
     public Estoque findById(Integer id) {
        Estoque object = (Estoque) session.get(Estoque.class, id);
        return object;
    }

    public void save(Estoque object) {
        Transaction u = session.beginTransaction();
        session.saveOrUpdate((Estoque) object);
        u.commit();
    }

    public void delete(Estoque object) {
        Transaction u = session.beginTransaction();
        session.delete((Estoque) object);
        u.commit();
    }

    public List<Estoque> listAll() {

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Estoque> query = builder.createQuery(Estoque.class);

        Root<Estoque> klassRoot = query.from(Estoque.class);

        query.select(klassRoot);

        List<Estoque> result = session.createQuery(query).getResultList();
        session.close();
        return result;

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Produto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistencia.HibernateUtil;

/**
 *
 * @author marci
 */
public class ProdutoDAO {

    private Session session = null;

    public ProdutoDAO() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    public Produto findById(Integer id) {
        Produto object = (Produto) session.get(Produto.class, id);
        return object;
    }

    public void save(Produto object) {
        Transaction t = session.beginTransaction();
        session.saveOrUpdate((Produto) object);
        t.commit();
    }

    public void delete(Produto object) {
        Transaction t = session.beginTransaction();
        session.delete((Produto) object);
        t.commit();
    }

    public List<Produto> listAll() {

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Produto> query = builder.createQuery(Produto.class);

        Root<Produto> klassRoot = query.from(Produto.class);

        query.select(klassRoot);

        List<Produto> result = session.createQuery(query).getResultList();
        session.close();
        return result;

    }
}

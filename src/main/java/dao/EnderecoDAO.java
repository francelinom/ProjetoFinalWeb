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
import model.Endereco;
import model.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistencia.HibernateUtil;

/**
 *
 * @author marci
 */
public class EnderecoDAO {

    private Session session = null;

    public EnderecoDAO() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    public Endereco findById(Integer id) {
        Endereco object = (Endereco) session.get(Endereco.class, id);
        return object;
    }

    public void save(Endereco object) {
        Transaction u = session.beginTransaction();
        session.saveOrUpdate((Endereco) object);
        u.commit();
    }

    public void delete(Endereco object) {
        Transaction u = session.beginTransaction();
        session.delete((Endereco) object);
        u.commit();
    }

    public List<Endereco> listAll() {

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Endereco> query = builder.createQuery(Endereco.class);

        Root<Endereco> klassRoot = query.from(Endereco.class);

        query.select(klassRoot);

        List<Endereco> result = session.createQuery(query).getResultList();

        return result;

    }
}

package bean;

import dao.UsuarioDAO;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistencia.HibernateUtil;

public class teste1 {

    public static void main(String[] args) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();

        //UsuarioDAO dao = new UsuarioDAO();
        Date d1 = new GregorianCalendar(1986, Calendar.FEBRUARY, 03).getTime();

        Usuario u = new Usuario("Francelino", "999999999", "vai da certo", d1, "999999999", "fran", "123", "123", true);
        Endereco e = new Endereco("Rua de jundiai", 11, "EAJ", "Macaiba", "RN");
        //Estoque estoque = new Estoque(1, "", 0, d1, d1)
        
        u.setEndereco(e);
        
        sessao.save(e);
        sessao.save(u);

        transacao.commit();
        transacao.begin();
        

    }

}

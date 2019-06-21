/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

/**
 *
 * @author marci
 */
import org.hibernate.Session;

public class Conecta {

    public static void main(String[] args) {
        System.out.println("Passei por aqui");
        Session sessao = null;
        sessao = HibernateUtil.getSessionFactory().openSession();
        System.out.println("Conectou!");
        sessao.close();
    }

}

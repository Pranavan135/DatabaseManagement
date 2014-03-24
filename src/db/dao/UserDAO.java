/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.dao;

import db.entity.User;
import db.util.HibernateUtil;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Pranavan
 */
public class UserDAO {

    private static Session session = null;
    private static Transaction transaction = null;
    private static SessionFactory sessFact = null;

    public static boolean isExist(String name) {
        Long count = 0L;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            count = (Long) session.createQuery("select count(*) from User u where u.name = :name")
                    .setParameter("name", name)
                    .uniqueResult();
            session.getTransaction().commit();
        } catch (Exception ex) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
            ex.printStackTrace();
            return false;
        }
        return count > 0;
    }

    public static User logIn(String name, String pass) {

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String hql = "FROM User u WHERE u.name = :name and u.password = :pass";
            Query query = session.createQuery(hql);
            query.setParameter("name", name);
            query.setParameter("pass", pass);
            User user = (User) query.uniqueResult();
            session.getTransaction().commit();
            return user;
        } catch (Exception ex) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
            ex.printStackTrace();
            return null;
        }
 
    }
   
    
    public static boolean addUser(String name,String password,Integer privilegeCode){
        try {
            sessFact = new Configuration().configure().buildSessionFactory();
            session = sessFact.openSession();
            transaction = session.beginTransaction();
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            user.setPrivilege(privilegeCode);
            session.save(user);
            transaction.commit();
            JOptionPane.showMessageDialog(null, "Record Added", "Details", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception ex) {
            return false;
        } finally {
            session.flush();
            session.close();
        }
    }
}

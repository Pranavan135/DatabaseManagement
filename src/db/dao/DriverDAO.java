/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.dao;

import db.entity.Driver;
import db.entity.DriverId;
import db.util.HibernateUtil;
import java.awt.HeadlessException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Pranavan
 */
public class DriverDAO {

    private static final String QUERY_BASED_ON_Name = "from drivers a where a.name like '";
    private static Session session = null;
    private static Transaction transaction = null;
    private static SessionFactory sessFact = null;

    public static boolean addData(Integer id, String name, String address, String tp_no) {
        try {
            sessFact = new Configuration().configure().buildSessionFactory();
            session = sessFact.openSession();
            transaction = session.beginTransaction();
            Driver driver = new Driver();
            DriverId driverId = new DriverId();
            driverId.setId(id);
            driverId.setName(name);
            driver.setId(driverId);
            driver.setAddress(address);
            driver.setTpNo(tp_no);
            session.save(driver);
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

    public static boolean editData() {
        return true;
    }

    public static boolean updateData(Integer id, String name, String address, String teleno) {
        try {
            sessFact = new Configuration().configure().buildSessionFactory();
            session = sessFact.openSession();
            transaction = session.beginTransaction();
            String hql = "UPDATE Driver d set d.id.name = :name, d.address = :address, d.tpNo = :teleno"  +"WHERE d.id.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("name", name);
            query.setParameter("address",address);
            query.setParameter("teleno", teleno);
            
            /*String hql = "from Driver d where d.id.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            Driver driver = (Driver) query.uniqueResult();*/
            
        } catch (HibernateException hibernateException) {
        }
        
        
        return true;
    }

    public static boolean deleteData(Integer id) {
        Session sess = null;
        Transaction tran = null;
        try {
            sessFact = new Configuration().configure().buildSessionFactory();
            sess = sessFact.openSession();
            tran = sess.beginTransaction();
            String hql = "DELETE FROM Driver d " + "WHERE d.id.id = :id";
            Query query = sess.createQuery(hql);
            query.setParameter("id", id);
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);
            tran.commit();
            //JOptionPane.showMessageDialog(null, "Record Added","Details", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            sess.flush();
            sess.close();
        }
    }

    public static List viewDrivers(String name, Integer id) {
        String hql = "from Driver d where d.id.name like '" + name + "%' and d.id.id like '" + id + "%'";

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query q = session.createQuery(hql);
            List resultList = q.list();
            session.getTransaction().commit();
            return resultList;
        } catch (HibernateException | HeadlessException he) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
            he.printStackTrace();
        }
        return null;
    }

    public static boolean isExistDriver(Integer id) {
        Long count = 0L;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            count = (Long) session.createQuery("select count(*) from Driver d where d.id.id = :id")
                    .setInteger("id", id)
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
}

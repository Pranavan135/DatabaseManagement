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
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
    
      private static String QUERY_BASED_ON_Name = "from drivers a where a.name like '";
    
    public static boolean addData(Integer id,String name,String address,String tp_no){
        Session sess = null;
        Transaction tran = null;
        try {
            SessionFactory sessFact = new Configuration().configure().buildSessionFactory();
            sess = sessFact.openSession();
            tran = sess.beginTransaction();
            Driver driver = new Driver();
            DriverId driverId = new DriverId();
            driverId.setId(id);
            driverId.setName(name);
            driver.setId(driverId);
            driver.setAddress(address);
            driver.setTpNo(tp_no);
            sess.save(driver);
            tran.commit();
            JOptionPane.showMessageDialog(null, "Record Added","Details", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            sess.flush();
            sess.close();
        }
    } 
    
    public static boolean editData(){
        return true;
    }
    
    public static boolean updateData(){
        return true;
    }
    
    public static boolean deleteData(Integer id){
        Session sess = null;
        Transaction tran = null;
        try {
            SessionFactory sessFact = new Configuration().configure().buildSessionFactory();
            sess = sessFact.openSession();
            tran = sess.beginTransaction();
            String hql = "DELETE FROM Driver d "  + "WHERE d.id.id = :id";
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
    

   public static List viewDrivers(String name,Integer id){
       Session session = null;
        Transaction transaction = null;
        String hql = "from Driver d where d.id.name like '"+name + "%' and d.id.id like '" + id+"%'";
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query q = session.createQuery(hql);
            List resultList = q.list();
            session.getTransaction().commit();
            return resultList;
        }
        catch (HibernateException|HeadlessException he) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
            he.printStackTrace();
        }
        return null;
   }
}

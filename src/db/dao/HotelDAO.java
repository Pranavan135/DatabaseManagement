/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db.dao;

import db.entity.Bill;
import db.entity.Hotel;
import db.entity.Town;
import db.util.HibernateUtil;
import java.awt.HeadlessException;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DELL
 */
public class HotelDAO {
    private static HotelDAO hotelDAO = null;
    
     public static HotelDAO create()  {
        if (hotelDAO == null) {
              hotelDAO = new HotelDAO();
        }
            return hotelDAO;
    }
     
     public Hotel isUnique(String ID)    {
        Session session = null;
        Transaction transaction = null;
        
        try {
            session =  HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String HQL = "from Hotel h where h.id = :ID";
           
            Query q = session.createQuery(HQL) ;
            
            try{
                q.setParameter("ID", Integer.parseInt(ID));
            }
            catch(NumberFormatException n){ return null;}
            Hotel h = (Hotel)q.uniqueResult();

            session.getTransaction().commit();
            
           return h;
        }
        catch (HibernateException|HeadlessException he) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
            he.printStackTrace();
             return null;
        }
        finally {
            session.close();
        }
       
    }
     
      public List getAllTowns() {
           
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (session == null) {
            return null;
        }
        Transaction transaction = null;
        try {
            String HQLQuery = "FROM Town t where overNightStop = true";
            Query query = session.createQuery(HQLQuery);
            List towns = query.list();
            return towns;
        } catch (HibernateException | HeadlessException ex) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return null;
    }
      
      public Town getTown(String townId)  {
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query q = session.createQuery("from Town where id = :ID") ;
            try{
                q.setParameter("ID", Integer.parseInt(townId));
            }
            catch(NumberFormatException n){return null;}
            Town t = (Town) q.uniqueResult();
            session.getTransaction().commit();
            return t;
        }
        catch (HibernateException|HeadlessException he) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
            he.printStackTrace();
        }
        finally {
          session.close();
        }
        return null;
    }
      
      public boolean addHotel(Hotel hotel) {
         Session session = HibernateUtil.getSessionFactory().openSession();
         Transaction transaction = null;
         
         if (session == null) {
            return false;
        }
         try{
            transaction = session.beginTransaction();
            session.save(hotel);
            session.flush();
            transaction.commit();
            return true;
          } 
         catch (HibernateException | HeadlessException ex) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return false;
    }
      
      public boolean editHotel(Hotel hotel) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        if (session == null) {
            return false;
        }
       
        try {
            transaction = session.beginTransaction();
            session.update(hotel);
            session.flush();
            transaction.commit();
            return true;
        } catch (HibernateException | HeadlessException ex) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
             JOptionPane.showMessageDialog(null, ex,"ERROR", JOptionPane.ERROR_MESSAGE);
            
        } finally {
            session.close();
        }
        return false;
    }
      
      public boolean deleteHotel(Hotel hotel) {
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(hotel);
            session.flush();
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
          session.flush();
           session.close();
        }
    }
      
      public Hotel getHotel(String hotelId)  {
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query q = session.createQuery("from Hotel where id = :ID") ;
            
            try{
                q.setParameter("ID", Integer.parseInt(hotelId));
            }
            catch(NumberFormatException n){ return null;}
            Hotel t = (Hotel)q.uniqueResult();
            session.getTransaction().commit();
            
            return t;
        }
        catch (HibernateException|HeadlessException he) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
            he.printStackTrace();
        }
        finally {
            session.close();
        }
        return null;
    }
      
       public List searchOnHotelId(String hotelID) {
            List list = executeHQLQuery("from Hotel h where h.id like '" + hotelID + "%'");
            return list;
       }

       public List searchHotelName(String hotelName) {
            List list = executeHQLQuery("from Hotel h where h.name like '" + hotelName + "%'");
            return list;
        }
       
       public List searchTownName(String townName) {
            List list = executeHQLQuery("from Hotel h where h.town.name like '" + townName + "%'");
            return list;
        }

        private List executeHQLQuery(String hql) {
            Session session = null;
            Transaction transaction = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                transaction = session.beginTransaction();
                Query q = session.createQuery(hql);
                java.util.List resultList = q.list();
                session.getTransaction().commit();
                return resultList;
                
            } catch (HibernateException he) {
                 if (transaction != null && transaction.wasCommitted()) {
                    transaction.rollback();
                }
                he.printStackTrace();
                return null;
            }
            finally{
              //  session.close();
            }
    }
}

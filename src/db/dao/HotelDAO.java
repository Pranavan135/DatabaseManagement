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
            String HQL = "from Hotel h where h.id ='" + ID +"'";
           
            Query q = session.createQuery(HQL) ;
            Hotel h = (Hotel)q.uniqueResult();

            session.getTransaction().commit();
            
           return h;
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
            Query q = session.createQuery("from Town where id = '" + townId +"'") ;
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
}

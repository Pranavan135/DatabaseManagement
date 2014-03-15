/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db.dao;

import db.entity.Bill;
import db.entity.Hotel;
import db.entity.RouteTown;
import db.entity.Tour;
import db.entity.Town;
import db.util.HibernateUtil;
import java.awt.HeadlessException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author 110592A
 */
public class BillDAO {
    private static String QUERY_BASED_ON_REFERENCE_NO = "from Bill b where b.refNo like '"; 
    private static BillDAO billDAO = null;
    
     public static BillDAO create()  {
        if (billDAO == null) {
              billDAO = new BillDAO();
        }
            return billDAO;
    }
     
    public boolean addBill(Bill bill) {
         Session session = HibernateUtil.getSessionFactory().openSession();
         Transaction transaction = null;
         
         if (session == null) {
            return false;
        }
         try{
            transaction = session.beginTransaction();
            session.save(bill);
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

    public boolean editBill(Bill bill) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        if (session == null) {
            return false;
        }
       
        try {
            transaction = session.beginTransaction();
            session.update(bill);
            session.flush();
            transaction.commit();
            return true;
        } catch (HibernateException | HeadlessException ex) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return false;
    }
    
    public List searchOnReferenceNo(String referenceNo) {
        List list = viewBills(QUERY_BASED_ON_REFERENCE_NO + referenceNo + "%'");
        return list;
    }
    
    private List viewBills(String hql) {
        Session session = null;
        Transaction transaction = null;
        
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
    
    public boolean deleteBill(Bill bill) {
       Session session = null;
        Transaction transaction = null;
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(bill);
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
    
    public Bill isUnique(String referenceNo)    {
        Session session = null;
        Transaction transaction = null;
        
        try {
            session =  HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String HQL = "from Bill b where b.refNo ='" + referenceNo +"'";
           
            Query q = session.createQuery(HQL) ;
            Bill b= (Bill)q.uniqueResult();

            session.getTransaction().commit();
            
           return b;
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
         finally {
           // session.close();
        }
        return null;
        
    }
    
    public Tour getTour(String tourCode)  {
        Session session = null;
        Transaction transaction = null;
       
         try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query q = session.createQuery("from Tour where tourCode ='" + tourCode + "'") ;
            Tour t = (Tour)q.uniqueResult();
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
        //    session.close();
        }
        return null;
    }
    
    public Hotel getHotel(String hotelId)  {
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query q = session.createQuery("from Hotel where id = '" +hotelId+"'") ;
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
            //session.close();
        }
        return null;
    }
    
     public List getAllTours() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (session == null) {
            return null;
        }
        Transaction transaction = null;
        try {
            String HQLQuery = "FROM Tour t ";
            Query query = session.createQuery(HQLQuery);
            List tours = query.list();
            return tours;
        } catch (HibernateException | HeadlessException ex) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
        } finally {
            //session.close();
        }
        return null;
    }
     
     public Set<Hotel> getAllHotels(Tour tour) {
        Set<RouteTown> route = tour.getRoute().getRouteTowns();
        
        Set<Hotel> hotel = new HashSet<Hotel>();
        
        for (RouteTown r : route)   {
            Town t = r.getTown();
            if (t.getOverNightStop()) {
                if(t.getHotel() != null) {
                hotel.add(t.getHotel());
                }
                
            }
        }
            
        return hotel;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db.dao;

import db.entity.Bill;
import db.entity.Hotel;
import db.entity.Tour;
import db.entity.Town;
import db.util.HibernateUtil;
import java.awt.HeadlessException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author 110592A
 */
public class BillDAO {
    private static String QUERY_BASED_ON_REFERENCE_NO = "from Bill b where b.refno like '"; 
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
    
    public boolean isUnique(String referenceNo)    {
        List list = viewBills(QUERY_BASED_ON_REFERENCE_NO +  referenceNo);
        
        if (list.isEmpty())
            return true;
        else 
            return false;
    }
    
    public Town getTown(String townId)  {
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query q = session.createQuery("from Town where id = :townId") ;
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
    
    public Tour getTour(String tourCode)  {
        Session session = null;
        Transaction transaction = null;
       
         try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query q = session.createQuery("from Tour where tour_code = :tourCode") ;
            Tour t = (Tour)q.uniqueResult();
            session.getTransaction().commit();
        }
        catch (HibernateException|HeadlessException he) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
            he.printStackTrace();
        }
        return null;
    }
    
    public Hotel getHotel(String hotelId)  {
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query q = session.createQuery("from Hotel where id = :hotelId") ;
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
        return null;
    }
}

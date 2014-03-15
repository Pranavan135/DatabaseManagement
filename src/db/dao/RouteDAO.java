/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.dao;

import db.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import db.entity.RouteTownId;
import java.awt.HeadlessException;
import java.util.List;
import org.hibernate.Query;
import db.entity.Route;
import db.entity.RouteTown;
import db.entity.Town;
import java.util.ArrayList;
//import javax.swing.JOptionPane;

/**
 *
 * @author userr
 */
public class RouteDAO {
    
   private static String QUERY_BASED_ON_REFERENCE_NO = "from Route r where r.id like '"; 
    private static RouteDAO routeDAO = null;
  
    public static RouteDAO create(){
        if (routeDAO == null){
             routeDAO = new RouteDAO();
        }
        return routeDAO;
        
    }
    
    public boolean addRoute(Route route){
        Session session = HibernateUtil.getSessionFactory().openSession();
         Transaction transaction = null;
         
         if (session == null) {
            return false;
        }
         try{
            transaction = session.beginTransaction();
            session.save(route);
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
    
     public boolean addRouteTown(RouteTown route_town){
        
         Session session = HibernateUtil.getSessionFactory().openSession();
         Transaction transaction = null;
         
         if (session == null) {
            return false;
        }
         try{
            transaction = session.beginTransaction();
            session.save(route_town);
            session.flush();
            transaction.commit();
            return true;
          } 
         catch (HibernateException | HeadlessException ex) {
             ex.printStackTrace();
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return false;
    }
     
    public boolean updateRoute(Route route){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
    
        if (session == null)
            return false;
        try{
            transaction =  session.beginTransaction();
            session.update(route);
            session.flush();
            transaction.commit();
            return true;
        }
        catch(HibernateException he){
            if (transaction != null && transaction.wasCommitted())
                transaction.rollback();
        }
        finally{
            session.close();
        }
        return false;
       
    }
    
    public boolean deleteRouteTown(RouteTownId route_town){
        
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = null;
    
            if (session == null)
                return false;
            try{
                transaction =  session.beginTransaction();
                session.delete(route_town);
                session.flush();
                transaction.commit();
                return true;
            }
            
        catch(HibernateException he){
            if (transaction != null && transaction.wasCommitted())
                transaction.rollback();
        }
            finally{
                session.close();
            }
            return false;
    }
    
    public boolean deleteRoute(Route route) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
    
        if (session == null) {
            return false;
        }
        try {
            transaction = session.beginTransaction();
            session.delete(route);
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
    
    public Route getRoute(String r_id){
        
        int rid = Integer.parseInt(r_id);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
    
        if (session == null){
            return null;
        }
       
        try{
            transaction =  session.beginTransaction();
            String HQLQuery = "From Route r where r.id =" + rid;
            Query query = session.createQuery(HQLQuery);
            Object result = query.uniqueResult();
            transaction.commit();
            if (result != null && result instanceof Route) {
                return (Route)result;
        }
        }
        catch(HibernateException he){
            if (transaction != null && transaction.wasCommitted())
                transaction.rollback();
        }
        finally{
            session.close();
        }
        return null;
    }
    
    /*public List<Route> getAllRoute(){
         Session session = HibernateUtil.getSessionFactory().openSession();
         Transaction transaction = null;
    
        if (session == null) {
            return null;
        }
        
        try {
            transaction = session.beginTransaction();
            String HQLQuery = "From Route r";
            Query query = session.createQuery(HQLQuery);
            List<Route> result = query.list();
            session.flush();
            transaction.commit();
            return result;
            
        } catch (HibernateException | HeadlessException ex) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return null;
    }*/
    
     public List searchOnReferenceNo(String referenceNo) {
          List list = getAllRoute(QUERY_BASED_ON_REFERENCE_NO + referenceNo + "%'");
        return list;
    }
    
    private List getAllRoute(String hql) {
        Session session = HibernateUtil.getSessionFactory().openSession();
         Transaction transaction = null;
    
        if (session == null) {
            return null;
        }
        
        try {
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
        }
        return null;
    }
    
    public List<Integer> getAllRouteID(){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
    
        if (session == null) {
            return null;
        }
        
        try {
            transaction = session.beginTransaction();
            String HQLQuery = "select r.id From Route r";
            Query query = session.createQuery(HQLQuery);
            List<Integer> result = query.list();
            session.flush();
            transaction.commit();
            return result;
            
        } catch (HibernateException | HeadlessException ex) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return null;
        
    }
    
    public ArrayList<Integer> getAllTownID(){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
    
        if (session == null) {
            return null;
        }
        
        try {
            transaction = session.beginTransaction();
            String HQLQuery = "select town.id From Town town";
            Query query = session.createQuery(HQLQuery);
            ArrayList<Integer> result = new ArrayList(query.list());
            session.flush();
            transaction.commit();
            return result;
            
        } catch (HibernateException | HeadlessException ex) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return null;
        
    }
    
     public Town getTown(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
    
        if (session == null) {
            return null;
        }
        
        try {
            String HQLQuery = "FROM Town t WHERE t.id = :idValue";

            Query query = session.createQuery(HQLQuery);
            query.setParameter("idValue", id);
            Object town = query.uniqueResult();

            if (town != null && town instanceof Town) {
                return (Town) town;
            }
        } catch (HibernateException | HeadlessException ex) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return null;
    }
    
    public boolean isUnique(String id){
       Route output =  getRoute(id);
        return output == null;  
    }
    
   public boolean isExist(String id){
       Route output = getRoute(id);
       if (output != null)
           return true;
       else
       return false;
   }
    
   
    
}

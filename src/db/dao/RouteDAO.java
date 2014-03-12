/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.dao;

import db.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import db.entity.Route;
import java.awt.HeadlessException;
import java.util.List;
import org.hibernate.Query;
import db.entity.Route;
/**
 *
 * @author userr
 */
public class RouteDAO {
    
   // private static String QUERY_BASED_ON_ROUTE_ID = "from route r where r.id like '";
    private static RouteDAO routeDAO = null;
    Transaction transaction = null;
    
    public static RouteDAO create(){
        if (routeDAO == null){
             routeDAO = new RouteDAO();
        }
        return routeDAO;
        
    }
    
    public boolean addRoute(Route route){
        
            Session session = HibernateUtil.getSessionFactory().openSession();
            
            if (session == null)
                return false;
            try{
                session.beginTransaction();
                session.save(route);
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
    
    public boolean updateRoute(Route route){
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        if (session == null)
            return false;
        try{
            session.beginTransaction();
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
    public boolean deleteRoute(Route route) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (session == null) {
            return false;
        }
        Transaction transaction = null;
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
        if (session == null){
            return null;
        }
       
        try{
            session.beginTransaction();
            String HQLQuery = "From Route r where r.id = rid";
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
    
    public List<Route> getAllRoute(){
         Session session = HibernateUtil.getSessionFactory().openSession();
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
    }
    
    public boolean isUnique(String id){
       Route output =  getRoute(id);
       if (output == null)
           return true;
       else
           return false;  
    }
    
   
    
   
    
}

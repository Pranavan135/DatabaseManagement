/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.dao;

import db.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author userr
 */
public class RouteDAO {
    
    private static String QUERY_BASED_ON_ROUTE_ID = "from route r where r.id like '";
    private static RouteDAO routeDAO = null;
    Transaction transaction = null;
    
    public RouteDAO create(){
        if (routeDAO == null){
             routeDAO = new RouteDAO();
        }
        return routeDAO;
        
    }
    
    public boolean addRoute(){
        
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
    
    public boolean updateRoute(){
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
    
    public boolean view(){
        
    }
}

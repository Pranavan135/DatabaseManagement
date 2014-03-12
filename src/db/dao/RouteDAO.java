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
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author userr
 */
public class RouteDAO {
    
    private static String QUERY_BASED_ON_ROUTE_ID = "from route r where r.id like '";
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
    
    public List executeViewRouteData(int id){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
       
        try{
            session.beginTransaction();
            Query query = session.createQuery(QUERY_BASED_ON_ROUTE_ID + id + "%'");
            List result = query.list();
            transaction.commit();
            return result;
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
    
    public boolean isUnique(int id){
       List output =  executeViewRouteData(id);
       if (output.isEmpty())
           return true;
       else
           return false;  
    }
}

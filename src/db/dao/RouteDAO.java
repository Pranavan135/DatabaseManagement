/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.dao;

import db.entity.Driver;
import db.entity.DriverRoute;
import db.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.awt.HeadlessException;
import java.util.List;
import org.hibernate.Query;
import db.entity.Route;
import db.entity.RouteTown;
import db.entity.Town;

/**
 *
 * @author Annet
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
    
    public boolean deleteRouteTown(RouteTown route_town){
        
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
    
    public boolean deleteDriverRoute(DriverRoute driver_route){
        
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = null;
    
            if (session == null)
                return false;
            try{
                transaction =  session.beginTransaction();
                session.delete(driver_route);
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
  
    public List searchOnRouteID(String referenceNo) {
          List list = getAllRoute(QUERY_BASED_ON_REFERENCE_NO + referenceNo + "%'");
        return list;
    }
     
    public List searchOnRouteName(String routeName) {
            List list = getAllRoute("from Route r where r.name like '" + routeName + "%'");
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
   
    public Town getTown(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
    
        if (session == null) {
            return null;
        }
        
        try {
            transaction = session.beginTransaction();
            String HQLQuery = "FROM Town t WHERE t.id = :idValue";

            Query query = session.createQuery(HQLQuery);
            query.setParameter("idValue", id);
            Object town = query.uniqueResult();
             session.flush();
             transaction.commit();
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
     
    public List getRouteTown(String routeID){
      
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
    
        if (session == null) {
            return null;
        }
        
        try {
          transaction = session.beginTransaction();
            String HQLQuery = "From RouteTown rt where rt.id.routeId like '" + routeID + "%'";
            Query query = session.createQuery(HQLQuery);
            
            List routeTown = query.list();       
            session.flush();
            transaction.commit();
            
            if ( routeTown != null ) {
                return routeTown;
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
   
    public List getDriverRoute(String routeID){
      
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
    
        if (session == null) {
            return null;
        }
        
        try {
          transaction = session.beginTransaction();
            String HQLQuery = "From DriverRoute dr where dr.id.routeId like '" + routeID + "%'";
            Query query = session.createQuery(HQLQuery);
            
            List driverRoute = query.list();       
            session.flush();
            transaction.commit();
            
            if ( driverRoute != null ) {
                return driverRoute;
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
     
    public RouteTown getRouteTown1(String routeID, String townID){
      
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
    
        if (session == null) {
            return null;
        }
        
        try {
          transaction = session.beginTransaction();
            String HQLQuery = "From RouteTown rt where rt.id.routeId = :r_id and rt.id.townId = :t_id";
            Query query = session.createQuery(HQLQuery);
            query.setParameter("t_id",new Integer(townID));
            query.setParameter("r_id", new Integer(routeID));
             RouteTown routeTown = (RouteTown)query.uniqueResult();
           
            session.flush();
            transaction.commit();
            return routeTown;
        
        }
        
        catch (HibernateException | HeadlessException ex) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }
        return null;
    } 
     
    public DriverRoute getDriverRoute1(int routeID, int driverID){
      
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
    
        if (session == null) {
            return null;
        }
        
        try {
          transaction = session.beginTransaction();
            String HQLQuery = "From DriverRoute dr where dr.id.routeId = :r_id and dr.id.driverId = :d_id";
            Query query = session.createQuery(HQLQuery);
            query.setParameter("r_id", routeID);
            query.setParameter("d_id", driverID);
            DriverRoute driverRoute = (DriverRoute)query.uniqueResult();
           
            session.flush();
            transaction.commit();
            return driverRoute;
        
        }
        
        catch (HibernateException | HeadlessException ex) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
                ex.printStackTrace();
            }
        } finally {
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
            String HQLQuery = "FROM Town t";
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
   
    public boolean isUniqueRouteTown(String routeID, String townID){
      
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
    
        if (session == null) {
            return false;
        }
        
        try {
            transaction = session.beginTransaction();
            String HQLQuery = "From RouteTown rt where rt.id.routeId = :r_id and rt.id.townId = :t_id";
           
            Query query = session.createQuery(HQLQuery);
            query.setParameter("r_id",new Integer(routeID) );
            query.setParameter("t_id",new Integer( townID));
            Object routeTown = query.uniqueResult();
            session.flush();
            transaction.commit();
            if ( routeTown != null ) {
                 return false;
            }
        } catch (HibernateException | HeadlessException ex) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return true;
    }
    
    public boolean isUniqueDriverRoute(int routeID, int driverID){
      
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
    
        if (session == null) {
            return false;
        }
        
        try {
            transaction = session.beginTransaction();
            String HQLQuery = "From DriverRoute dr where dr.id.routeId = :r_id and dr.id.driverId = :d_id";
           
            Query query = session.createQuery(HQLQuery);
            query.setParameter("r_id",routeID);
            query.setParameter("d_id",driverID);
            Object routeTown = query.uniqueResult();
            session.flush();
            transaction.commit();
            if ( routeTown != null ) {
              return false;
            }
        } catch (HibernateException | HeadlessException ex) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return true;
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
    
    public  Driver getDriver(int id) {
      
       Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
    
        if (session == null){
            return null;
        }
       
        try{
            transaction =  session.beginTransaction();
            String hql = "From Driver d where d.id.id = :idValue";
            Query query = session.createQuery(hql);
            query.setParameter("idValue", id);
           
            Driver driver = (Driver)query.uniqueResult();
            session.flush();
            transaction.commit();
            return driver; 
            
            }
        catch (HibernateException | HeadlessException ex) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }
        return null;
    }
    
    public boolean addDriverRoute(DriverRoute driverRoute){
        
         Session session = HibernateUtil.getSessionFactory().openSession();
         Transaction transaction = null;
         
         if (session == null) {
            return false;
        }
         try{
            transaction = session.beginTransaction();
            session.save(driverRoute);
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
            session.flush();
            session.close();
        }
        return false;
    }
    
    public List<Integer> getAllDriverID(){
      
    Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
    
        if (session == null) {
            return null;
        }
        
        try {
            transaction = session.beginTransaction();
            String HQLQuery = "select d.id.id From Driver d";
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
}

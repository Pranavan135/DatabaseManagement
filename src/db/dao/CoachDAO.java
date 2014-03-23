/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db.dao;

import db.entity.Coach;
import db.entity.Driver;
import db.entity.DriverId;
import db.util.HibernateUtil;
import java.awt.HeadlessException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
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
public class CoachDAO {
    
    private static Session session = null;
    private static Transaction transaction = null;
    private static SessionFactory sessFact = null;

    
    public static boolean addCoach(Integer regNo, Integer capacity, Date date, Double mileage){
        try {
            sessFact = new Configuration().configure().buildSessionFactory();
            session = sessFact.openSession();
            transaction = session.beginTransaction();
            Coach coach = new Coach();
            coach.setRegNo(regNo);
            coach.setCapacity(capacity);
            coach.setLastServiceDate(date);
            coach.setLastServiceMileage(mileage);
            
            session.save(coach);
            transaction.commit();
           
            return true;
        } catch (Exception ex) {
            return false;
        } finally {
            session.flush();
            session.close();
        }
    }
    
    public static Coach getCoach(Integer regNo){
        Coach coach = new Coach();
        if (isExistCoach(regNo)) {
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                transaction = session.beginTransaction();
                String hql = "FROM Coach c WHERE c.regNo = :regNo";
                Query query = session.createQuery(hql);
                try{
                    query.setParameter("regNo", regNo);
                }
                catch(NumberFormatException n){return null;};
                List resultList = query.list();
                session.getTransaction().commit();
                coach = (Coach) resultList.get(0);
               
            } catch (HibernateException hibernateException) {
                hibernateException.printStackTrace();
                return null;
            }
        }
        return coach;
    }
    
    public static boolean isExistCoach(Integer regNo){
       Long count = 0L;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            try{
                count = (Long) session.createQuery("select count(*) from Coach c where c.regNo = :regNo")
                        .setInteger("regNo", regNo)
                        .uniqueResult();
                session.getTransaction().commit();
            }
            catch(NumberFormatException n){return false;}
        } catch (Exception ex) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
            ex.printStackTrace();
            return false;
        }
        return count > 0;
    }
    
    public static boolean updateData(Integer regNo,Integer capacity,Date lastServicedate,Double lastServiceMileage) {
        try {
            sessFact = new Configuration().configure().buildSessionFactory();
            session = sessFact.openSession();
            transaction = session.beginTransaction();
            
            String hql = "UPDATE Coach c set c.capacity = :capacity, c.lastServiceDate = :lastServicedate, c.lastServiceMileage = :lastServiceMileage WHERE c.regNo = :regNo";
            
            Query query = session.createQuery(hql);
            query.setParameter("regNo", regNo);
            query.setParameter("capacity",capacity );
            query.setParameter("lastServicedate", lastServicedate);
            query.setParameter("lastServiceMileage", lastServiceMileage);
        

            /*String hql = "from Driver d where d.id.id = :id";
             Query query = session.createQuery(hql);
             query.setParameter("id", id);
             Driver driver = (Driver) query.uniqueResult();*/
            query.executeUpdate();
            transaction.commit();
            JOptionPane.showMessageDialog(null, "Record Updated", "Details", JOptionPane.INFORMATION_MESSAGE);
            return true;

        } catch (HibernateException hibernateException) {
        }

        return true;
    }
    
    public static List viewCoaches(String regNo) {
        String hql = "from Coach d where d.regNo like '" + regNo + "%'";

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query q = session.createQuery(hql);
            List resultList = q.list();
            session.getTransaction().commit();
            return resultList;
        } catch (HibernateException | HeadlessException he) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
            he.printStackTrace();
        }
        return null;
    }

    
    public static Coach isUnique(String regNo)    {
        Session session = null;
        Transaction transaction = null;
        Integer regno = 0;
        try{
             regno = Integer.parseInt(regNo);
        }
        catch(NumberFormatException n){ return null;}
        
        try {
            session =  HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String HQL = "from Coach c where c.regNo =:regNo";
           
            Query q = session.createQuery(HQL) ;
            q.setParameter("regNo", regno);
            Coach coach = (Coach)q.uniqueResult();

            session.getTransaction().commit();
            
           return coach;
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
    
     public static boolean deleteCoach(Coach coach) {
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(coach);
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
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db.dao;

import db.entity.Bill;
import db.entity.Hotel;
import db.util.HibernateUtil;
import java.awt.HeadlessException;
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
}

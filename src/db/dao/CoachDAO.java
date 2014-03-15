/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db.dao;

import db.entity.Coach;
import db.entity.Driver;
import db.entity.DriverId;
import java.util.Date;
import javax.swing.JOptionPane;
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
            JOptionPane.showMessageDialog(null, "Record Added", "Details", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception ex) {
            return false;
        } finally {
            session.flush();
            session.close();
        }
    }
    
    
}

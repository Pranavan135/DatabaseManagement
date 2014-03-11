/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db.ui.dao;

import db.entity.Driver;
import db.entity.DriverId;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Pranavan
 */
public class DriverDAO {
    
    
    public static boolean addData(Integer id,String name,String address,String tp_no){
        Session sess = null;
        Transaction tran = null;
        try {
            SessionFactory sessFact = new Configuration().configure().buildSessionFactory();
            sess = sessFact.openSession();
            tran = sess.beginTransaction();
            Driver driver = new Driver();
            DriverId driverId = new DriverId();
            driverId.setId(id);
            driverId.setName(name);
            driver.setId(driverId);
            driver.setAddress(address);
            driver.setTpNo(tp_no);
            sess.save(driver);
            tran.commit();
            JOptionPane.showMessageDialog(null, "Record Added","Details", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            sess.flush();
            sess.close();
        }
    } 
    
    public static boolean editData(){
        return true;
    }
    
    public static boolean updateData(){
        return true;
    }
}

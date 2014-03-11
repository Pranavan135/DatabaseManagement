/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db.dao;

import db.entity.Driver;
import db.entity.DriverId;
import db.util.HibernateUtil;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
public class DriverDAO {
    
      private static String QUERY_BASED_ON_Name = "from drivers a where a.name like '";
    
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
    

    public static JTable runQueryBasedOnName(String name) {
       return executeHQLQuery(QUERY_BASED_ON_Name +"'"+ name + "%'");
    }

    private static JTable executeHQLQuery(String hql) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            java.util.List resultList = q.list();
            JTable jTable =displayResult(resultList);
            session.getTransaction().commit();
            return jTable;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return null;
    }


    private static JTable displayResult(List resultList) {
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("Id");
        tableHeaders.add("Name");
        tableHeaders.add("Address");
        tableHeaders.add("TelephoneNumber");

        for (Object o : resultList) {
            Driver driver = (Driver) o;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(driver.getId().getId());
            oneRow.add(driver.getId().getName());
            oneRow.add(driver.getAddress());
            oneRow.add(driver.getTpNo());
            tableData.add(oneRow);
        }
        JTable jTable=null;
        jTable.setModel(new DefaultTableModel(tableData, tableHeaders));
        return jTable;
    }
}

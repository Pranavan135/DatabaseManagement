/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db.dao;


import db.entity.Passenger;
import db.util.HibernateUtil;
import java.awt.HeadlessException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Vishnuvathsasarma
 */
public class PassengerDAO {
    public boolean addPassenger(Passenger passenger) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (session == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(passenger);
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

    public boolean updatePassenger(Passenger passenger) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (session == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(passenger);
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

    public List<Passenger> getAllPassenger() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (session == null) {
            return null;
        }
        Transaction transaction = null;
        try {
            String HQLQuery = "FROM Town t ";
            Query query = session.createQuery(HQLQuery);
            List<Passenger> towns = query.list();
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
}

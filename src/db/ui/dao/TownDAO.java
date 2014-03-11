package db.ui.dao;

import db.entity.Town;
import db.util.HibernateUtil;
import java.awt.HeadlessException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Gobinath
 */
public class TownDAO {

    public boolean addTown(Town town) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (session == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(town);
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

    public boolean updateTown(Town town) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (session == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(town);
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

    public List<Town> getAllTowns() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (session == null) {
            return null;
        }
        Transaction transaction = null;
        try {
            String HQLQuery = "FROM Town t ";
            Query query = session.createQuery(HQLQuery);
            List<Town> towns = query.list();
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

package db.dao;

import db.entity.Bill;
import db.entity.Coach;
import db.entity.Driver;
import db.entity.Hotel;
import db.entity.Passenger;
import db.entity.Route;
import db.entity.RouteTown;
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

    public boolean deleteTown(Town town) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (session == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(town);
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

    public boolean addRouteTown(RouteTown routeTown) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (session == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(routeTown);
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

    public Town getTown(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (session == null) {
            return null;
        }
        Transaction transaction = null;
        try {
            String HQLQuery = "FROM Town t WHERE t.id = :idValue";

            Query query = session.createQuery(HQLQuery);
            query.setParameter("idValue", id);
            Object town = query.uniqueResult();

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

    public List<Town> getTowns(Integer id, String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (session == null) {
            return null;
        }
        Transaction transaction = null;
        try {
            String HQLQuery = "FROM Town t ";
            if (id != null || !name.equals("")) {
                HQLQuery += "WHERE";
            }
            if (id != null) {
                HQLQuery += " t.id = :idValue";
            }
            if (id != null && !name.equals("")) {
                HQLQuery += " AND";
            }
            if (!name.equals("")) {
                HQLQuery += " t.name like :nameValue";
            }
            Query query = session.createQuery(HQLQuery);
            if (id != null) {
                query.setParameter("idValue", id);
            }
            if (!name.equals("")) {
                query.setParameter("nameValue", "%" + name + "%");
            }
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

    public Bill getBill(String strID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (session == null) {
            return null;
        }
        Transaction transaction = null;
        try {
            String HQLQuery = "FROM Bill b WHERE b.ref_no = :idValue";
            Query query = session.createQuery(HQLQuery);

            query.setParameter("idValue", Integer.parseInt(strID));
            Object bill = query.uniqueResult();
            return (bill == null) ? null : (Bill) bill;
        } catch (HibernateException | HeadlessException ex) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return null;
    }

    public Route getRoute(String strID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (session == null) {
            return null;
        }
        Transaction transaction = null;
        try {
            String HQLQuery = "FROM Route r WHERE r.id = :idValue";
            Query query = session.createQuery(HQLQuery);

            query.setParameter("idValue", Integer.parseInt(strID));
            Object route = query.uniqueResult();
            return (route == null) ? null : (Route) route;
        } catch (HibernateException | HeadlessException ex) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return null;
    }

    public Hotel getHotel(String strID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (session == null) {
            return null;
        }
        Transaction transaction = null;
        try {
            String HQLQuery = "FROM Hotel h WHERE h.id = :idValue";
            Query query = session.createQuery(HQLQuery);

            query.setParameter("idValue", Integer.parseInt(strID));
            Object hotel = query.uniqueResult();
            return (hotel == null) ? null : (Hotel) hotel;
        } catch (HibernateException | HeadlessException ex) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return null;
    }

    public List<Hotel> getAllHotels() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (session == null) {
            return null;
        }
        Transaction transaction = null;
        try {
            String HQLQuery = "FROM Hotel h ";
            Query query = session.createQuery(HQLQuery);
            List<Hotel> hotels = query.list();
            return hotels;
        } catch (HibernateException | HeadlessException ex) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return null;
    }

    public List<Bill> getAllBills() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (session == null) {
            return null;
        }
        Transaction transaction = null;
        try {
            String HQLQuery = "FROM Bill b ";
            Query query = session.createQuery(HQLQuery);
            List<Bill> bills = query.list();
            return bills;
        } catch (HibernateException | HeadlessException ex) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return null;
    }

    public List<Route> getAllRoutes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (session == null) {
            return null;
        }
        Transaction transaction = null;
        try {
            String HQLQuery = "FROM Route r ";
            Query query = session.createQuery(HQLQuery);
            List<Route> routes = query.list();
            return routes;
        } catch (HibernateException | HeadlessException ex) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return null;
    }

    public List<Driver> getAllDrivers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (session == null) {
            return null;
        }
        Transaction transaction = null;
        try {
            String HQLQuery = "FROM Driver d ";
            Query query = session.createQuery(HQLQuery);
            List<Driver> drivers = query.list();
            return drivers;
        } catch (HibernateException | HeadlessException ex) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return null;
    }

    public List<Coach> getAllCoaches() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (session == null) {
            return null;
        }
        Transaction transaction = null;
        try {
            String HQLQuery = "FROM Coach c ";
            Query query = session.createQuery(HQLQuery);
            List<Coach> coachs = query.list();
            return coachs;
        } catch (HibernateException | HeadlessException ex) {
            if (transaction != null && transaction.wasCommitted()) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return null;
    }

    public Passenger getPassenger(int ID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (session == null) {
            return null;
        }
        Transaction transaction = null;
        try {
            String HQLQuery = "FROM Passenger p WHERE p.id= " + ID;
            Query query = session.createQuery(HQLQuery);
            Passenger passenger = (Passenger) query.uniqueResult();
            return passenger;
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

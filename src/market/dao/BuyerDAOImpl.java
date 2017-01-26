package market.dao;


import market.bean.Buyer;
import market.bean.BuyerType;
import market.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class BuyerDAOImpl implements BuyerDAO {
    public static SessionFactory factory;

    public BuyerDAOImpl() {
        factory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void create(String name) {
        Transaction transaction = null;
        BuyerType btype = new BuyerTypeDAOImpl().read(1);
        try (Session session = factory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("select count(*) from Buyer where lower(name) = :name ");
            query.setParameter("name", name.toLowerCase());
            Long num = (Long) query.getSingleResult();

            if (num == null) {
                Buyer newBuyer = new Buyer(name);
                newBuyer.setAddress("Ne dom i ne ulitsa");
                newBuyer.setPhone("2741001");
                newBuyer.setBtype(btype);
                session.save(newBuyer);
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void create(Buyer buyer) {
        Transaction transaction = null;
        try (Session session = factory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.save(buyer);
            transaction.commit();
        }
    }

    @Override
    public Buyer read(Integer id) {
        Transaction transaction = null;
        Buyer buyer = null;
        try (Session session = factory.getCurrentSession()) {
            transaction = session.beginTransaction();
            buyer = (Buyer) session.get(Buyer.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return buyer;
    }

    @Override
    public void update(Integer id, String name) {
        Transaction transaction = null;
        Buyer buyer = read(1);
        try (Session session = factory.getCurrentSession()) {
            transaction = session.beginTransaction();
            buyer.setName(name);
            session.update(buyer);
            transaction.commit();
            System.out.println("Update complete");
        } catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(Buyer buyer) {
        Transaction transaction = null;
        try (Session session = factory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("update Buyer set name=:name, address=:address, phone=:phone, btype=:btype " + "where id=:id");
            query.setParameter("name", buyer.getName());
            query.setParameter("address", buyer.getAddress());
            query.setParameter("phone", buyer.getPhone());
            query.setParameter("btype", buyer.getBtype());
            int result = query.executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        Transaction transaction = null;
        Buyer buyer = read(1);
        try (Session session = factory.getCurrentSession()) {
            transaction = session.beginTransaction();
            if (buyer != null) {
                session.delete(buyer);
                transaction.commit();
                System.out.println("Successfully deleted");
            } else {
                System.out.println("Buyer with this ID was not found");
            }
        }
    }

    @Override
    public Buyer find(Integer id) {
        return null;
    }

    @Override
    public List<Buyer> listAll() {
        Transaction transaction = null;
        ArrayList<Buyer> list = new ArrayList<>();
        try (Session session = factory.getCurrentSession()) {
            transaction = session.beginTransaction();
            list = (ArrayList<Buyer>) session.createQuery("from Buyer").getResultList();
            transaction.commit();
        }
        return list;
    }
}
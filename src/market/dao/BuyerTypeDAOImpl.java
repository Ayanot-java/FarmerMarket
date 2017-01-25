package market.dao;

import market.bean.BuyerType;
import market.bean.FarmerType;
import market.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;

public class BuyerTypeDAOImpl implements BuyerTypeDAO {

    private static SessionFactory factory;

    public BuyerTypeDAOImpl() {
        super();
        factory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void create(String name) {
        Transaction tx = null;
        try(Session session = factory.getCurrentSession())
        {
            tx = session.beginTransaction();
            Query query = session.createQuery("select count(*) from BuyerType where lower(name) = :name");
            query.setParameter("name",name.toLowerCase());
            Long num = (Long) query.getSingleResult();

            if(num == 0)
            {
                BuyerType bt = new BuyerType(name);
                session.save(bt);
            }
            tx.commit();
        }
        catch (HibernateException e)
        {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public BuyerType read(Integer id) {
        Transaction tx = null;
        BuyerType bt = null;

        try(Session session = factory.getCurrentSession()) {
            tx = session.beginTransaction();
            bt = (BuyerType) session.get(BuyerType.class, id);
            tx.commit();
        }
        catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return bt;
    }

    @Override
    public void update(Integer id, String name) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public ArrayList<BuyerType> listAll() {
        Transaction tx = null;
        ArrayList<BuyerType> list = new ArrayList<>();
        try (Session session = factory.getCurrentSession()) {
            tx = session.beginTransaction();
            list = (ArrayList<BuyerType>)session.createQuery("From BuyerType").getResultList();
            tx.commit();
        }
        catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BuyerType find(Integer id) {
        return null;
    }
}
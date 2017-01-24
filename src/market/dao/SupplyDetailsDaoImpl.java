package market.dao;

import market.bean.Pack;
import market.bean.Product;
import market.bean.Supply;
import market.bean.SupplyDetails;
import market.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;

/**
 * Created by Tane4ka on 23.01.2017.
 */
public class SupplyDetailsDaoImpl implements SupplyDetailsDao{

    private static SessionFactory factory;

    public SupplyDetailsDaoImpl() {
        super();
        factory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void create(SupplyDetails supplyDetails) {

        Transaction tx = null;
        try (Session session = factory.getCurrentSession()) {
            tx = session.beginTransaction();
            session.save(supplyDetails);
            tx.commit();
            System.out.println("Records inserted successfully");

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void create(Float qnt, Float sprice, Product product, Supply supply, Pack pack) {
        Transaction tx = null;
        SupplyDetails sd = new SupplyDetails(qnt, sprice, product, supply, pack);
        try (Session session = factory.getCurrentSession()) {
            tx = session.beginTransaction();
            session.save(sd);
            tx.commit();
            System.out.println("Records inserted successfully");

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<SupplyDetails> read(Supply supply) {
        Transaction tx = null;
        ArrayList<SupplyDetails> suppliesDetails = null;
        try(Session session = factory.getCurrentSession())
        {
            tx = session.beginTransaction();
            Query query = session.createQuery("from SupplyDetails where supply=:supply");
            query.setParameter("supply", supply);
            suppliesDetails = (ArrayList<SupplyDetails>) query.getResultList();
            tx.commit();
        }
        catch (HibernateException e)
        {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
        return suppliesDetails;
    }

    @Override
    public void update(SupplyDetails supplyDetails) {
        Transaction tx = null;
        try(Session session = factory.getCurrentSession())
        {
            tx = session.beginTransaction();
            Query query = session.createQuery("update SupplyDetails set qnt=:qnt, sprice=:price, product=:product " +
                    "where id=:id");
            query.setParameter("qnt", supplyDetails.getQnt());
            query.setParameter("price", supplyDetails.getSprice());
            query.setParameter("product", supplyDetails.getProduct());
            query.setParameter("id", supplyDetails.getId());
            int result = query.executeUpdate();
            tx.commit();
        }
        catch (HibernateException e)
        {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Float qnt, Float price) {
        Transaction tx = null;
        try(Session session = factory.getCurrentSession())
        {
            tx = session.beginTransaction();
            Query query = session.createQuery("update SupplyDetails set qnt=:qnt, sprice=:price where id=:id");
            query.setParameter("qnt", qnt);
            query.setParameter("price", price);
            query.setParameter("id", id);
            query.executeUpdate();
            tx.commit();
        }
        catch (HibernateException e)
        {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {

    }
}

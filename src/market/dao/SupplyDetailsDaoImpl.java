package market.dao;

import market.bean.Product;
import market.bean.Supply;
import market.bean.SupplyDetails;
import market.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
    public ArrayList<SupplyDetails> read(Supply supply) {
        Transaction tx = null;
        ArrayList<SupplyDetails> suppliesDetails = null;
        try(Session session = factory.getCurrentSession())
        {
            tx = session.beginTransaction();
            Query query = session.createQuery("from SupplyDetails where supplyId=:supplyId ");
            query.setParameter("supplyId", supply.getId());
            suppliesDetails = (ArrayList<SupplyDetails>) query.getResultList();
            tx.commit();
        }
        catch (HibernateException e)
        {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(SupplyDetails supplyDetails) {
        Transaction tx = null;
        try(Session session = factory.getCurrentSession())
        {
            tx = session.beginTransaction();
            Query query = session.createQuery("update SupplyDetails set qnt=:qnt, price=:price, productId=:productId " +
                    "where id=:id");
            query.setParameter("qnt", supplyDetails.getQnt());
            query.setParameter("price", supplyDetails.getPrice());
            query.setParameter("productId", supplyDetails.getProductId());
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
    public void delete(int id) {

    }
}

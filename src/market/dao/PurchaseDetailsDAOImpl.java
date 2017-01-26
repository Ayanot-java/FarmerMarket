package market.dao;

import market.bean.Purchase;
import market.bean.PurchaseDetails;
import market.bean.Stock;
import market.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.*;

/**
 * Created by Helen on 24.01.2017.
 */
public class PurchaseDetailsDAOImpl implements PurchaseDetailsDAO {

    private static SessionFactory sessionFactory;

    public PurchaseDetailsDAOImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void create(Purchase purchase, Stock stock){

        Transaction tx = null;

        try(Session session = sessionFactory.getCurrentSession()){

            tx = session.beginTransaction();
            Query query = session.createQuery("select count(*) from PurchaseDetails where purchase = :id and Stock = :stock");

            query.setParameter("id", purchase).setParameter("stock", stock);


            Long num = (Long) query.getSingleResult();

            if(num == 0){

                PurchaseDetails purchaseDetails = new PurchaseDetails(purchase, stock);
                session.save(purchaseDetails);
            }
            tx.commit();
        }
        catch (HibernateException e){

            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
    }

    public PurchaseDetails read(Integer detailsId){

        Transaction tx = null;
        PurchaseDetails purchaseDetails = null;

        try(Session session = sessionFactory.getCurrentSession()){

            tx = session.beginTransaction();
            purchaseDetails = session.get(PurchaseDetails.class, detailsId);
            tx.commit();
        }
        catch (HibernateException e){

            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
        return purchaseDetails;
    }

    public void update(PurchaseDetails purchaseDetails){

        Transaction tx = null;

        try(Session session = sessionFactory.getCurrentSession()){

            tx = session.beginTransaction();
            session.saveOrUpdate(purchaseDetails);
            tx.commit();
        }
        catch (HibernateException e){

            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void delete(Integer detailsId){}

    public List<PurchaseDetails> listAll(){

        Transaction tx = null;
        List<PurchaseDetails> result = new LinkedList<>();

        try(Session session = sessionFactory.getCurrentSession()){

            tx = session.beginTransaction();
            result = session.createQuery("from PurchaseDetails").getResultList();
            tx.commit();
        }
        catch (HibernateException e){

            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
        return result;
    }

    public List<PurchaseDetails> findAllByPurchase(Purchase purchase){

        Transaction tx = null;
        List<PurchaseDetails> result = new LinkedList<>();

        try(Session session = sessionFactory.getCurrentSession()){

            tx = session.beginTransaction();
            result = session.createQuery("from PurchaseDetails where purchase = :purchase")
                    .setParameter("purchase",purchase).getResultList();
            tx.commit();
        }
        catch (HibernateException e){

            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
        return result;
    }

}

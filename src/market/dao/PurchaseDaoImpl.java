package market.dao;

import market.bean.Buyer;
import market.bean.Purchase;
import market.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Helen on 18.01.2017.
 */
public class PurchaseDaoImpl implements PurchaseDAO{

    private static SessionFactory sessionFactory;

    public PurchaseDaoImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void create(Buyer buyer){  // new Purchase

        Transaction tx = null;

        try(Session session = sessionFactory.getCurrentSession()){ //используем try с параметром для того, чтобы сессия закрылась
                                                                  //самостоятельно после исполнения этого блока
            tx = session.beginTransaction();
            Query query = session.createQuery("select count(*) from Purchase where buyer = :id and pDate = :date");
            Date now = new Date();
            /**
             * Need to do something to this Date-thing
             */
            query.setParameter("id",buyer).setParameter("date", now);


            Long num = (Long) query.getSingleResult();

            if(num == 0){

                Purchase purchase = new Purchase(buyer);
                session.save(purchase);
            }
            tx.commit();
        }
        catch (HibernateException e){

            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void delete(Integer id){

    }
    public Purchase read(Integer id){
        Transaction tx = null;
        Purchase purchase = null;

        try(Session session = sessionFactory.getCurrentSession()){

            tx = session.beginTransaction();
            purchase = session.get(Purchase.class, id);
            tx.commit();
        }
        catch (HibernateException e){

            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
        return purchase;
    }

    public List<Purchase> listAll(){
        Transaction tx = null;
        List<Purchase> result = new LinkedList<>();

        try(Session session = sessionFactory.getCurrentSession()){

            tx = session.beginTransaction();
            result = session.createQuery("from Purchase").getResultList();
            tx.commit();
        }
        catch (HibernateException e){

            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
        return result;
    }
    public List<Purchase> findAllByBuyer(Buyer buyer){
        Transaction tx = null;
        List<Purchase> result = new LinkedList<>();

        try(Session session = sessionFactory.getCurrentSession()){

            tx = session.beginTransaction();
            result = session.createQuery("from Purchase where buyer = :buyerId")
                    .setParameter("buyerId",buyer).getResultList();
            tx.commit();
        }
        catch (HibernateException e){

            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
        return result;
    }
}

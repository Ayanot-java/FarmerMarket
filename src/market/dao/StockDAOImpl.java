package market.dao;

import market.bean.Stock;
import market.bean.SupplyDetails;
import market.util.HibernateUtil;
import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.query.*;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.management.Query;

/**
 * Created by LazeL on 22.01.2017.
 */
public class StockDAOImpl implements StockDAO {
    private static SessionFactory factory;

    public StockDAOImpl() {
        super();
        factory = HibernateUtil.getSessionFactory();
    }


    @Override
    public void create(SupplyDetails supplyDetails) {
        Transaction tx = null;
        try (Session session = factory.getCurrentSession();) {
            tx = session.beginTransaction();
//            Query query = (Query) session.createQuery("");
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();

            }
        }

    }

    @Override
    public Stock read(Integer id) {

        Transaction tx = null;
        Stock readStock = null;
        try (Session session = factory.getCurrentSession()) {
            tx = session.beginTransaction();
            readStock = (Stock) session.get(Stock.class, id);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return readStock;
    }

    @Override
    public void update(Integer id, Float newAvailableQnt) {

        Transaction tx = null;
        try(Session session = factory.getCurrentSession()){
            tx = session.beginTransaction();
            Stock updatableStock = (Stock) session.load(Stock.class, id);
            Float qnt = updatableStock.getAvailableQnt();
            qnt = newAvailableQnt;
            session.update(updatableStock);
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
        }

    }

    @Override
    public void delete(Integer id) {
        Transaction tx = null;
        try(Session session = factory.getCurrentSession()){
            tx = session.beginTransaction();
            Stock stockToDelete = (Stock) session.load(Stock.class, id);
            session.delete(stockToDelete);
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
        }

    }
}
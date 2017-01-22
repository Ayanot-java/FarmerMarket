package market.dao;

import market.bean.Stock;
import market.bean.SupplyDetails;
import market.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.management.Query;

/**
 * Created by LazeL on 22.01.2017.
 */
public class StockDAOImpl implements StockDAO {
    private static SessionFactory factory;

    public StockDAOImpl(){
        super();
        factory = HibernateUtil.getSessionFactory();
    }


    @Override
    public void create(SupplyDetails supplyDetails) {
        Transaction tx = null;
        try(Session session = factory.getCurrentSession();)
        {
            tx = session.beginTransaction();
            Query query = session.createQuery("");
        }catch (HibernateException e){
            System.out.println(e.getStackTrace());
        }

    }

    @Override
    public Stock read(Integer id) {
        return null;
    }

    @Override
    public void update(Integer id, Float newAvailableQnt) {

    }

    @Override
    public void delete(Integer id) {

    }
}
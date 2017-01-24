package market.dao;

import market.bean.Farmer;
import market.bean.FarmerType;
import market.bean.Supply;
import market.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

/**
 * Created by Tane4ka on 18.01.2017.
 */
public class SupplyDaoImpl implements SupplyDao {

    private static SessionFactory factory;

    public SupplyDaoImpl() {
        super();
        factory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void create(Farmer farmer) {
        Transaction tx = null;
        try(Session session = factory.getCurrentSession())
        {
            tx = session.beginTransaction();
            Supply supply = new Supply();
            supply.setFarmer(farmer);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            supply.setDate(dateFormat.format(new Date()));
            session.save(supply);
            tx.commit();
            System.out.println("Records inserted sucessessfully");

        }
        catch (HibernateException e)
        {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Supply read(Farmer farmer, Date saldate) {

        Transaction tx = null;

        try(Session session = factory.getCurrentSession())
        {
            tx = session.beginTransaction();

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
    public ArrayList<Supply> getAllOfFarmer(Farmer farmer, Date saldate) {
        Transaction tx = null;
        ArrayList<Supply> supplies = null;
        try(Session session = factory.getCurrentSession())
        {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Supply where farmer=:farmerid and date=:seldate ");
            query.setParameter("farmerid", farmer.getId());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            query.setParameter("seldate", dateFormat.format(saldate));
            supplies = (ArrayList<Supply>)query.getResultList();
            tx.commit();
        }
        catch (HibernateException e)
        {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
        return supplies;
    }

    @Override
    public ArrayList<Supply> getAllForData(Date saldate) {
        Transaction tx = null;
        ArrayList<Supply> supplies = null;
        try(Session session = factory.getCurrentSession())
        {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Supply where date=:seldate ");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            query.setParameter("seldate", dateFormat.format(saldate));
            supplies = (ArrayList<Supply>)query.getResultList();
            tx.commit();
        }
        catch (HibernateException e)
        {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
        return supplies;
    }

    @Override
    public void update(Farmer farmer, Date saldate) {
//        Transaction tx = null;
//        try(Session session = factory.getCurrentSession())
//        {
//            tx = session.beginTransaction();
//            Query query = session.createQuery("update Supply  where farmer=:farmerid and date=:seldate");
//            query.setParameter("farmerid", farmer.getId());
//            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//            query.setParameter("seldate", dateFormat.format(saldate));
//            int result = query.executeUpdate();
//            tx.commit();
//        }
//        catch (HibernateException e)
//        {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }
    }

    @Override
    public void delete(Farmer farmer, Date saldate) {

//        Transaction tx = null;
//        try (Session session = factory.getCurrentSession()) {
//            tx = session.beginTransaction();
//            Query query = session.createQuery("delete from Supply where farmer=:farmerid and date=:seldate");
//            query.setParameter("farmerid", farmer.getId());
//            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//            query.setParameter("seldate", dateFormat.format(saldate));
//            int result = query.executeUpdate();
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null) tx.rollback();
//            e.printStackTrace();
//        }
    }
    @Override
        public ArrayList<Supply> listAll() {
        Transaction tx = null;
        ArrayList<Supply> supplies = null;
        try(Session session = factory.getCurrentSession())
        {
            tx = session.beginTransaction();
            supplies = (ArrayList<Supply>) session.createQuery("from Supply").getResultList();
            tx.commit();
        }
        catch (HibernateException e)
        {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
        return supplies;
    }
}

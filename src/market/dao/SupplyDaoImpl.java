package market.dao;

import market.bean.Farmer;
import market.bean.Supply;
import market.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;

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
    public Supply create(Farmer farmer) {
        Transaction tx = null;
        Supply s = null;
        try(Session session = factory.getCurrentSession())
        {
            tx = session.beginTransaction();
            Supply supply = new Supply(farmer);
            Integer id = (Integer) session.save(supply);
            s = session.get(Supply.class, id);
            tx.commit();
            System.out.println("Records inserted sucessfully");
        }
        catch (HibernateException e)
        {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public Supply read(Integer id) {
        Transaction tx = null;
        Supply s = null;
        try(Session session = factory.getCurrentSession())
        {
            tx = session.beginTransaction();
            s = session.get(Supply.class, id);
            tx.commit();
        }
        catch (HibernateException e)
        {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public Supply read(Farmer farmer, Date sDate) {

        Transaction tx = null;
        Supply s = null;
        try(Session session = factory.getCurrentSession())
        {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Supply where farmer=:farmer and sdate=:sdate ");
            query.setParameter("farmer", farmer);
            query.setParameter("sdate", sDate);
            s = (Supply) query.getSingleResult();
            tx.commit();
        }
        catch (HibernateException e)
        {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public ArrayList<Supply> getAllOfFarmer(Farmer farmer) {
        Transaction tx = null;
        ArrayList<Supply> supplies = null;
        try(Session session = factory.getCurrentSession())
        {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Supply where farmer=:farmer");
            query.setParameter("farmer", farmer);
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
    public ArrayList<Supply> getAllForData(Date sDate) {
        Transaction tx = null;
        ArrayList<Supply> supplies = null;
        try(Session session = factory.getCurrentSession())
        {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Supply where DATE(sdate)=DATE(:sdate)");
            query.setParameter("sdate", sDate);
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
    public void update(Farmer farmer, Date sDate) {
//        Transaction tx = null;
//        try(Session session = factory.getCurrentSession())
//        {
//            tx = session.beginTransaction();
//            Query query = session.createQuery("update Supply  where farmer=:farmerid and sdate=:sdate");
//            query.setParameter("farmerid", farmer);
//            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//            query.setParameter("sdate", dateFormat.format(sDate));
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

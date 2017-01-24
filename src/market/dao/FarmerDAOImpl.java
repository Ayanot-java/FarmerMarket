package market.dao;

import market.bean.Farmer;
import market.bean.FarmerType;
import market.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp comp on 20.01.2017.
 */
public class FarmerDAOImpl implements FarmerDAO {
    public static SessionFactory factory;
    public FarmerDAOImpl() {
        factory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void create(String name) {
        Transaction transaction = null;
        FarmerType ftype = new FarmerTypeDAOImpl().read(1);
        try (Session session = factory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("select count(*) from Farmer where lower(name) = :name");
            query.setParameter("name", name.toLowerCase());
            Long num = (Long) query.getSingleResult();

            if(num == 0)
            {
                Farmer newFarmer = new Farmer(name);
                newFarmer.setAddress("Ayanot");
                newFarmer.setPhone("7875456");
                newFarmer.setFtype(ftype);
                session.save(newFarmer);
            }
            transaction.commit();
            }
            catch (HibernateException e)
            {
                if (transaction!=null) transaction.rollback();
                e.printStackTrace();
            }
    }

    @Override
    public void delete(Integer id) {
        Transaction transaction = null;
        Farmer farmer = read(id);
        try (Session session = factory.getCurrentSession()) {
            transaction = session.beginTransaction();
            if (farmer!=null) {
                session.delete(farmer);
                transaction.commit();
                System.out.println("Successfully deleted");
            }
            else {
                System.out.println("Farmer with this ID is not found");
            }
        }
    }

    @Override
    public void update(Integer id, String name) {
        Transaction transaction = null;
        Farmer farmer = read(id);
        try (Session session = factory.getCurrentSession()) {
            transaction = session.beginTransaction();
            farmer.setName(name);
            session.update(farmer);
            transaction.commit();
            System.out.println("Update complete");
        }
    }

    @Override
    public Farmer read(Integer id) {
        Transaction transaction = null;
        Farmer farmer = null;
        try(Session session = factory.getCurrentSession())
        {
            transaction = session.beginTransaction();
            farmer = (Farmer) session.get(Farmer.class, id);
            transaction.commit();
            /*session.close();
            factory.close();*/
        }
        catch (HibernateException e)
        {
            if (transaction!=null) transaction.rollback();
            e.printStackTrace();
        }
        return farmer;
    }

    @Override
    public Farmer find (Integer id) {
        return null;
    }

    @Override
    public List<Farmer> listAll() {
        Transaction transaction = null;
        ArrayList <Farmer> farmerList = new ArrayList<>();
        try (Session session = factory.getCurrentSession()) {
            transaction = session.beginTransaction();
            farmerList = (ArrayList<Farmer>) session.createQuery("from Farmer").getResultList();
            transaction.commit();
        }
        return farmerList;
    }
}

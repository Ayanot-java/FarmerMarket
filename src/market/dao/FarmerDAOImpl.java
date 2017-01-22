package market.dao;

import market.bean.Farmer;
import market.bean.FarmerType;
import market.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
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
        FarmerType type = new FarmerTypeDAOImpl().read(1);
        try (Session session = factory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("select count(*) from Farmer where lower(name) = :name");
            query.setParameter("name", name.toLowerCase());
            Long num = (Long) query.getSingleResult();

            if(num == 0)
            {
                Farmer newFarmer = new Farmer(name);
                newFarmer.setAdress("Ayanot");
                newFarmer.setPhone("7875456");
                newFarmer.setType(type);
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
    public void delete(int id) {

    }

    @Override
    public void update(int id) {

    }

    @Override
    public Farmer read(int id) {
        return null;
    }

    @Override
    public Farmer find(int id) {
        return null;
    }

    @Override
    public List<Farmer> listAll() {
        return null;
    }
}

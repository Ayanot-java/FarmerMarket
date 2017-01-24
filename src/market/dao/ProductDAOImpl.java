package market.dao;

import market.bean.Product;
import market.bean.ProductType;
import market.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;

/**
 * Created by Geraltsx on 23.01.2017.
 */
public class ProductDAOImpl implements ProductDAO {

    private static SessionFactory factory;

    public ProductDAOImpl() {

        this.factory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void create(String name, ProductType ptype) {

        Transaction tx = null;
        try (Session session = factory.getCurrentSession()) {
            tx = session.beginTransaction();
            Query query = session.createQuery("select count(*) from Product where lower(name) = :name and ptype =:ptype");
            query.setParameter("name", name.toLowerCase());
            query.setParameter("ptype", ptype);
            Long num = (Long) query.getSingleResult();

            if (num == 0) {
                Product product = new Product(name, ptype);
                session.save(product);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Product read(Integer id) {
        Transaction tx = null;
        Product p = null;

        try (Session session = factory.getCurrentSession()) {
            tx = session.beginTransaction();
            p = (Product) session.get(Product.class, id);

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public void update(Integer id, String name, String image, ProductType ptype) {
        Transaction tx = null;

        try (Session session = factory.getCurrentSession()) {
            tx = session.beginTransaction();
            Query query = session.createQuery("update Product set name =:name, image = :image, ptype =:ptype where id = :id");
            query.setParameter("name", name);
            query.setParameter("image", image);
            query.setParameter("ptype", ptype);
            query.setParameter("id", id);

            int result = query.executeUpdate();

            if (result == 0) {
                System.out.println("Не найден Product с таким id");
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }


    }

    @Override
    public void addImage(Integer id, String image) {

        Transaction tx = null;
        try (Session session = factory.getCurrentSession()) {

            tx = session.beginTransaction();
            Query query = session.createQuery("update Product set image =: image where id =: id");
            query.setParameter("image", image);
            query.setParameter("id", id);

            int result = query.executeUpdate();

            if (result == 0) {
                System.out.println("Не найден Product с таким id");
            }
            tx.commit();
        } catch (
                HibernateException e)

        {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Integer id) {
        Transaction tx = null;

        try (Session session = factory.getCurrentSession()) {
            tx = session.beginTransaction();
            Query query = session.createQuery("delete Product where  id =: id");
            query.setParameter("id", id);

            int result = query.executeUpdate();

            if (result == 0) {
                System.out.println("Не найден Product с таким id");
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Product> listAll() {
        Transaction tx = null;
        ArrayList<Product> list = new ArrayList<>();

        try (Session session = factory.getCurrentSession()) {
            tx = session.beginTransaction();
            list = (ArrayList<Product>) session.createQuery("from Product").getResultList();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Product find(String name) {
        Transaction tx = null;
        Product p = null;

        try (Session session = factory.getCurrentSession()) {
            tx = session.beginTransaction();
            p = (Product) session.get(Product.class, name);

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return p;
    }
}
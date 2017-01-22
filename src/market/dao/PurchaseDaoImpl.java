package market.dao;

import market.bean.Buyer;
import market.bean.Purchase;
import market.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Helen on 18.01.2017.
 */
public class PurchaseDaoImpl implements PurchaseDAO{

    private static SessionFactory sessionFactory;

    public PurchaseDaoImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    public void create(Buyer buyer){};
    public void delete(Integer id){};
    public List<Purchase> listAll(){};
    public List<Purchase> findAllByBuyer(Buyer buyer){};
    public Purchase read(Integer id){};





}

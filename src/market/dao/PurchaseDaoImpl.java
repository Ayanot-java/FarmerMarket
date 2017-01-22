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
    public void delete(Integer id){}
	@Override
	public List<Purchase> listAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Purchase> findAllByBuyer(Buyer buyer) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Purchase read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	};
  //  public List<Purchase> listAll(){};
 //   public List<Purchase> findAllByBuyer(Buyer buyer){};
//    public Purchase read(Integer id){};





}

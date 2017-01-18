package market.dao;

import market.bean.Buyer;
import market.bean.Purchase;

import java.util.List;

/**
 * Created by Helen on 18.01.2017.
 */
public interface PurchaseDAO {

    public void create(Buyer buyer);
    public void delete(Integer id);
    public List<Purchase> listAll();
    public List<Purchase> findAllByBuyer(Buyer buyer);
    public Purchase read(Integer id);

    /*
    CRUD
    public void create(Buyer);  //new Purchase,
    public void delete(Integer id);  // empty
    List listAll
    ArrayList<Purchase>findAllbyBuyer(buyer)
    public Purcase read(id);

    */

}

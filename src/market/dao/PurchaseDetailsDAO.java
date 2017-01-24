package market.dao;

import market.bean.*;

import java.util.List;

/**
 * Created by Helen on 18.01.2017.
 */
public interface PurchaseDetailsDAO {

    public void create(Purchase purchase, Stock stock);
    public PurchaseDetails read(Integer id);
    public void update(PurchaseDetails purchaseDetails);
    public void delete(Integer id);
    public List<PurchaseDetails> listAll();
    public List<PurchaseDetails> findAllByPurchase(Purchase purchase);


}

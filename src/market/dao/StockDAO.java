package market.dao;

import market.bean.Stock;
import market.bean.SupplyDetails;

/**
 * Created by LazeL on 22.01.2017.
 */
public interface StockDAO {
    public void create(SupplyDetails supplyDetails);
    public Stock read(Integer id);
    public void update(Integer id, Float newAvailableQnt);
    public void delete(Integer id);
}

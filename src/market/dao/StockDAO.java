package market.dao;

import market.bean.Stock;

/**
 * Created by LazeL on 22.01.2017.
 */
public interface StockDAO {
    public void create(Stock stock);
    public Stock read(Integer id);
    public void update(Integer id, Float availableQNT);
    public void delete();
}

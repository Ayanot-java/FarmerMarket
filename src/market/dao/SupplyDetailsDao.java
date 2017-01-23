package market.dao;

import market.bean.Farmer;
import market.bean.Product;
import market.bean.Supply;
import market.bean.SupplyDetails;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Tane4ka on 23.01.2017.
 */
public interface SupplyDetailsDao {

    public void create(SupplyDetails supplyDetails);
    public ArrayList<SupplyDetails> read(Supply supply);
    public void update(SupplyDetails supplyDetails);
    public void delete(int id);

}

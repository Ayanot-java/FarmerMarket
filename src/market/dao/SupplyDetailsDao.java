package market.dao;

import market.bean.Pack;
import market.bean.Product;
import market.bean.Supply;
import market.bean.SupplyDetails;

import java.util.ArrayList;

/**
 * Created by Tane4ka on 23.01.2017.
 */
public interface SupplyDetailsDao {

    public void create(SupplyDetails supplyDetails);
    public void create(Float qnt, Float sprice, Product product, Supply supply, Pack pack);
    public SupplyDetails create(Float qnt, Float price, Integer product, Supply supply);
    public ArrayList<SupplyDetails> read(Supply supply);
    public void update(SupplyDetails supplyDetails);
    public void update(Integer id, Float qnt, Float price);
    public void delete(Integer id);





}

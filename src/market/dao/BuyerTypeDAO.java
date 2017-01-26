package market.dao;

import market.bean.BuyerType;

import java.util.ArrayList;

public interface BuyerTypeDAO {
    void create(BuyerType buyerType);
    void create(String name);
    BuyerType read(Integer id);
    void update(Integer id, String name);
    void delete(Integer id);
    ArrayList<BuyerType> listAll();
    BuyerType find(Integer id);
}
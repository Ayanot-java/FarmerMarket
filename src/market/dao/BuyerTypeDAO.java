package market.dao;

import market.bean.BuyerType;

import java.util.ArrayList;

public interface BuyerTypeDAO {
    public void create(String name);
    public BuyerType read(Integer id);
    public void update(Integer id, String name);
    public void delete(Integer id);
    public ArrayList<BuyerType> listAll();
    public BuyerType find(Integer id);
}

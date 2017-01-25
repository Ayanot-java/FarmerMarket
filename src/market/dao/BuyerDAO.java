package market.dao;

import market.bean.Buyer;

import java.util.List;

public interface BuyerDAO {
    public void create(String name);
    public Buyer read(Integer id);
    public void update(Integer id, String name);
    public void delete(Integer id);
    public Buyer find(Integer id);
    public List<Buyer> listAll ();
}
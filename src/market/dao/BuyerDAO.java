package market.dao;

import market.bean.Buyer;

import java.util.List;

public interface BuyerDAO {
    void create(String name);
    void create(Buyer buyer);
    Buyer read(Integer id);
    void update(Integer id, String name);
    void update(Buyer buyer);
    void delete(Integer id);
    Buyer find(Integer id);
    List<Buyer> listAll ();
}
package market.dao;

import market.bean.ProductType;

import java.util.ArrayList;

/**
 * Created by Geraltsx on 23.01.2017.
 */
public interface ProductTypeDAO {

    ProductType read(Integer id);
    ProductType get(String name);
    void update(Integer id, String name);
    void delete (Integer id);
    ArrayList<ProductType> listAll();
    ProductType find(Integer id);
    void create(String name);
}

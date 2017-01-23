package market.dao;

import market.bean.Product;
import market.bean.ProductType;

import java.util.ArrayList;

/**
 * Created by Geraltsx on 23.01.2017.
 */
public interface ProductDAO {

    void create(String name, ProductType type);
    Product read(Integer id);
    void update(Integer id, String name, String image, ProductType type);
    void delete(Integer id);
    ArrayList<Product> listAll();
    Product find(String name);
    void addImage(Integer id, String image);
}

package market.dao;

import market.bean.Farmer;
import market.bean.Supply;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Tane4ka on 18.01.2017.
 */
public interface SupplyDao {

    public Supply create(Farmer farmer);
    public Supply read(Integer id);
    public Supply read(Farmer farmer, Date sdate);
    public ArrayList<Supply> getAllOfFarmer(Farmer farmer);
    public ArrayList<Supply> getAllForData(Date sdate);
    public void update(Farmer farmer, Date sdate);
    public void delete(Farmer farmer, Date sdate);
    public ArrayList<Supply> listAll();

}

package market.dao;

import market.bean.Farmer;
import market.bean.Supply;

import java.util.ArrayList;
import java.util.Date;



public interface SupplyDao {

    public void create(Farmer farmer);
    public Supply read(Farmer farmer, Date sDate);
    public ArrayList<Supply> getAllByFarmer(Farmer farmer);
    public ArrayList<Supply> getAllByData(Date sDate);
    public void update(Farmer farmer, Date sDate);
    public void delete(Farmer farmer, Date sDate);
    public ArrayList<Supply> listAll();

}

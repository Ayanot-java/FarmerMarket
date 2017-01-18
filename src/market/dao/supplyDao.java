package dao;

import bean.Farmer;
import bean.Supply;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Tane4ka on 18.01.2017.
 */
public interface supplyDao {

    public void create(Farmer farmer);
    public Supply read(Farmer farmer, Date saldate);
    public ArrayList<Supply> getAllOfFarmer(Farmer farmer, Date saldate);
    public ArrayList<Supply> getAllForData(Date saldate);
    public void update(Farmer farmer, Date saldate);
    public void delete(Farmer farmer, Date saldate);
    public ArrayList<Supply> listAll();

}

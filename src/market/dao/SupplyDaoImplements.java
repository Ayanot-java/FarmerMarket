package market.dao;

import market.bean.Farmer;
import market.bean.Supply;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Tane4ka on 18.01.2017.
 */
public class SupplyDaoImplements implements SupplyDao {

    @Override
    public void create(Farmer farmer) {

    }

    @Override
    public Supply read(Farmer farmer, Date saldate) {
        return null;
    }

    @Override
    public ArrayList<Supply> getAllOfFarmer(Farmer farmer, Date saldate) {
        return null;
    }

    @Override
    public ArrayList<Supply> getAllForData(Date saldate) {
        return null;
    }

    @Override
    public void update(Farmer farmer, Date saldate) {

    }

    @Override
    public void delete(Farmer farmer, Date saldate) {

    }

    @Override
    public ArrayList<Supply> listAll() {
        return null;
    }
}

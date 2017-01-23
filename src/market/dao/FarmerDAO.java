package market.dao;

import market.bean.Farmer;
import market.bean.FarmerType;

import java.util.List;

/**
 * Created by hp comp on 20.01.2017.
 */
public interface FarmerDAO {
   // public Farmer farmer;
    public void create (String name);
    public void delete (int id);
    public void update(int id, String name);
    public Farmer read (int id);
    public Farmer find (int id);
    public List<Farmer> listAll ();
}

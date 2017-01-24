package market.dao;

import market.bean.Farmer;

import java.util.List;

/**
 * Created by hp comp on 20.01.2017.
 */
public interface FarmerDAO {
   // public Farmer farmer;
    public void create (String name);
    public void delete (Integer id);
    public void update(Integer id, String name);
    public Farmer read (Integer id);
    public Farmer find (Integer id);
    public List<Farmer> listAll ();
}

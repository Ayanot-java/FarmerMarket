package market.dao;

import java.util.ArrayList;

import market.bean.FarmerType;

public interface FarmerTypeDAO 
{
	public void create(String name);
	public FarmerType read(Integer id);
	public void update(Integer id, String name);
	public void delete(Integer id);
	public ArrayList<FarmerType> listAll();
	public FarmerType find(Integer id);
}

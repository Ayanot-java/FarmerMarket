package market.dao;

import java.util.ArrayList;

import market.bean.FarmerType;
import market.bean.User;

public interface UserDAO {

		public void create(User user);
		public User read(Integer id);
		public void delete(Integer id);
		public void update(Integer id);
		public ArrayList<User> listAll();
		
}

package market.dao;

import java.util.ArrayList;

import market.bean.FarmerType;
import market.bean.User;

public interface UserDAO {

		public void create(String userName, String passwd );
		public User read(String username);
		public void delete(Integer id);
		public void update(Integer id);
		public ArrayList<User> listAll();
		
}

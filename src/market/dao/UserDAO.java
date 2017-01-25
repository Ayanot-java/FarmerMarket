package market.dao;

import market.bean.User;

import java.util.ArrayList;

public interface UserDAO {

		public void create(User user);
		public User read(Integer id);
		public void delete(Integer id);
		public void update(Integer id);
		public ArrayList<User> listAll();
		
}

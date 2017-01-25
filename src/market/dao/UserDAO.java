package market.dao;

import java.util.ArrayList;

import market.bean.User;

public interface UserDAO {

	void create(String userName, String pass) throws Exception;

	User read(Integer id);

	User read(String username);
	User read(String username, String pass);
	void delete(Integer id) throws Exception;
	void update(Integer id);
	ArrayList<User> listAll();

}
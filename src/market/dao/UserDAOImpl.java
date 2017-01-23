package market.dao;

import market.bean.User;
import market.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitaly Sokolov on 22.01.2017.
 */
public class UserDAOImpl implements UserDAO {
	//TODO: Implement methods
	SessionFactory factory = HibernateUtil.getSessionFactory();

	@Override
	public void create(String username, String passwd) throws Exception {
		if(read(username) == null){
			Transaction tx = null;
			try {
				Session session = factory.openSession();
				tx = session.beginTransaction();
				session.save(new User(username, passwd));
				tx.commit();
				session.close();
			} catch (Exception e){
				if (tx != null){
					tx.rollback();
					e.printStackTrace();
				}
			}
		}else{
			throw new Exception("Username is already in use. Choose another one");
		}
	}

	@Override
	public User read(Integer id) {
		Session session = factory.openSession();
		String hql = "from User U where U.id = :id";
		Query<User> query = session.createQuery(hql, User.class);
		query.setParameter("id", id);
		Transaction tx = session.beginTransaction();
		List<User> results = query.list();
		if (results.isEmpty()){
			return null;
		}
		else{
			return results.get(0);
		}
	}

	@Override
	public User read(String username) {
		Session session = factory.openSession();
		String hql = "from User U where U.username = :username";
		Query<User> query = session.createQuery(hql);
		query.setParameter("username", username);
		Transaction tx = session.beginTransaction();
		List<User> results = query.list();
		if (results.isEmpty()){
			return null;
		}
		else{
			return results.get(0);
		}
	}

	@Override
	public User read(String username, String passwd) {
		Session session = factory.openSession();
		String hql = "from User U where U.username = :username AND U.passwd = :passwd";
		Query<User> query = session.createQuery(hql);
		query.setParameter("username", username);
		query.setParameter("passwd", passwd);
		Transaction tx = session.beginTransaction();
		List<User> results = query.list();
		if (results.isEmpty()){
			return null;
		}
		else{
			return results.get(0);
		}
	}

	@Override
	public void delete(Integer id) {

	}

	@Override
	public void update(Integer id) {

	}

	@Override
	public ArrayList<User> listAll() {
		return null;
	}
}

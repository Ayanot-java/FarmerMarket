package market.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (null == sessionFactory) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			//sessionFactory.openSession();
		}
		return sessionFactory;
	}
	
}

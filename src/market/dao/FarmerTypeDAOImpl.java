package market.dao;

import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import market.bean.FarmerType;
import market.util.HibernateUtil;

public class FarmerTypeDAOImpl implements FarmerTypeDAO 
{
	private static SessionFactory factory;

	public FarmerTypeDAOImpl() 
	{
		super();
		factory = HibernateUtil.getSessionFactory();
	}

	@Override
	public void create(String name) 
	{
		Transaction tx = null;
		try(Session session = factory.getCurrentSession())
		{			
			tx = session.beginTransaction();  
			Query query = session.createQuery("select count(*) from FarmerType where lower(name) = :name");
			query.setParameter("name",name.toLowerCase());
			Long num = (Long) query.getSingleResult();

			if(num == 0)
			{
				FarmerType bt = new FarmerType(name);
				session.save(bt);
			}
			tx.commit();
		}
		catch (HibernateException e) 
		{
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}	 
	}

	@Override
	public FarmerType read(Integer id) 
	{
		Transaction tx = null;
		FarmerType ft = null;

		try(Session session = factory.getCurrentSession())
		{			
			tx = session.beginTransaction();  
			ft = (FarmerType) session.get(FarmerType.class, id);

			tx.commit();
		}
		catch (HibernateException e) 
		{
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}	 
		return ft;
	}

	@Override
	public void update(Integer id, String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<FarmerType> listAll() 
	{
		Transaction tx = null;	 
		ArrayList<FarmerType> list = new ArrayList<>();

		try(Session session = factory.getCurrentSession())
		{	     
			tx = session.beginTransaction();  
			list = (ArrayList<FarmerType>)session.createQuery("From FarmerType").getResultList();
			tx.commit();
		}
		catch (HibernateException e) 
		{
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} 
		return list;
	}

	@Override
	public FarmerType find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}

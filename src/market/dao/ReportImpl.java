package market.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import market.util.HibernateUtil;

public class ReportImpl {
	
	private static SessionFactory factory;
	private final String sql0 = "select Farmer.name as \"farmerName\", Product.name as \"productName\", SupplyDetails.qnt as \"qnt\", SupplyDetails.sPrice as \"sPrice\" from Farmer, Product, Supply, SupplyDetails where (Farmer.id = Supply.idFarmer) and (Supply.id = SupplyDetails.idSupply) and (Product.id = SupplyDetails.idProduct) and (Supply.sDate = current_date());";
	private final String sql1 = "select Buyer.name as \"buyerName\", Product.name as \"productName\", PurchaseDetails.qnt as \"qnt\", PurchaseDetails.pPrice as \"pPrice\" from Buyer, Product, PurchaseDetails, Purchase, SupplyDetails where (Buyer.id = Purchase.idBuyer) and (Purchase.id = PurchaseDetails.idPurchase) and (PurchaseDetails.idSupplyDetails = SupplyDetails.id) and (SupplyDetails.idProduct = Product.id) and (Purchase.pDate = current_date());";
	private final String sql2 = "select sum(total) as \"sumTotalPrice\" from Purchase where pDate = current_date();";
	private final String sql3 = "select Product.name as \"productName\", Farmer.name as \"farmerName\", Stock.qnt as \"qnt\", Stock.sPrice as \"sPrice\", Stock.sDate as \"sDate\" from Stock, Product, Farmer where (Stock.idProduct = Product.id) and (Stock.idFarmer = Farmer.id) order by Stock.sDate desc;";
	private final String sql4 = "select Buyer.name as \"buyerName\", Product.name as \"productName\", PurchaseDetails.qnt as \"qnt\", PurchaseDetails.pPrice as \"pPrice\", Farmer.name as \"farmerName\", Pack.name as \"packName\" from Buyer, Purchase, PurchaseDetails, Supply, SupplyDetails, Product, Farmer, Pack where (Buyer.id = Purchase.idBuyer) and (Purchase.id = PurchaseDetails.idPurchase) and (PurchaseDetails.idSupplyDetails = SupplyDetails.id) and (SupplyDetails.idProduct = Product.id) and (SupplyDetails.idSupply = Supply.id) and (Supply.idFarmer = Farmer.id) and (PurchaseDetails.idPack = Pack.id) and (Purchase.pDate = current_date());";

	public ReportImpl() 
	{
		factory = HibernateUtil.getSessionFactory();
	}
	
	private List getReportCommonStructureResult(String sql) {
		Transaction tx = null;
		List results = null;
		try(Session session = factory.getCurrentSession()) {
			tx = session.beginTransaction();
			//SQLQuery query = session.createNativeQuery(sql);
			//query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			NativeQuery query = session.createNativeQuery(sql);
			//results = query.list();
			results = query.getResultList();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace(); 
			return null;
		}
		return results;
	}
	
	public List getReport0() {
		return getReportCommonStructureResult(sql0);
	}
	
	public List getReport1() {
		return getReportCommonStructureResult(sql1);
	}
	
	public List getReport2() {
		return getReportCommonStructureResult(sql2);
	}
	
	public List getReport3() {
		return getReportCommonStructureResult(sql3);
	}
	
	public List getReport4() {
		return getReportCommonStructureResult(sql4);
	}

}

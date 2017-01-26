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
	private final String sql0 = "select Farmer.name as \"farmerName\", Product.name as \"productName\", SupplyDetails.qnt as \"qnt\", SupplyDetails.sPrice as \"sPrice\" from Farmer, Product, Supply, SupplyDetails where (Farmer.id = Supply.farmer) and (Supply.id = SupplyDetails.supply) and (Product.id = SupplyDetails.product) and (Supply.sDate = current_date());";
	private final String sql1 = "select Buyer.name as \"buyerName\", Product.name as \"productName\", PurchaseDetails.qnt as \"qnt\", PurchaseDetails.pPrice as \"pPrice\" from Buyer, Product, PurchaseDetails, Purchase, SupplyDetails where (Buyer.id = Purchase.buyer) and (Purchase.id = PurchaseDetails.purchase) and (PurchaseDetails.supplyDetails = SupplyDetails.id) and (SupplyDetails.product = Product.id) and (Purchase.pDate = current_date());";
	private final String sql2 = "select sum(total) as \"sumTotalPrice\" from Purchase where pDate = current_date();";
	private final String sql3 = "select Product.name as \"productName\", Farmer.name as \"farmerName\", Stock.qnt as \"qnt\", SupplyDetails.sPrice as \"sPrice\", Supply.sDate as \"sDate\" from Stock, Product, Farmer, SupplyDetails, Supply where (Stock.supplyDetail = SupplyDetails.id) and (SupplyDetails.product = Product.id) and (SupplyDetails.supply = Supply.id) and (Supply.farmer = Farmer.id) order by Supply.sDate desc;";
	private final String sql4 = "select Buyer.name as \"buyerName\", Product.name as \"productName\", PurchaseDetails.qnt as \"qnt\", PurchaseDetails.pPrice as \"pPrice\", Farmer.name as \"farmerName\", Pack.name as \"packName\" from Buyer, Purchase, PurchaseDetails, Supply, SupplyDetails, Product, Farmer, Pack where (Buyer.id = Purchase.buyer) and (Purchase.id = PurchaseDetails.purchase) and (PurchaseDetails.supplyDetails = SupplyDetails.id) and (SupplyDetails.product = Product.id) and (SupplyDetails.supply = Supply.id) and (Supply.farmer = Farmer.id) and (PurchaseDetails.pack = Pack.id) and (Purchase.pDate = current_date());";

	public ReportImpl() 
	{
		factory = HibernateUtil.getSessionFactory();
	}
	
	private List getReportCommonStructureResult(String sql) {
		Transaction tx = null;
		List results = null;
		try(Session session = factory.getCurrentSession()) {
			tx = session.beginTransaction();
			SQLQuery query = session.createNativeQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			//NativeQuery query = session.createNativeQuery(sql);
			results = query.list();
			//results = query.getResultList();
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

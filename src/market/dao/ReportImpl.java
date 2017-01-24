package market.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import market.util.HibernateUtil;

public class ReportImpl {
	//getReport0, getReport1...
	
	private static SessionFactory factory;
	private final boolean isDebug = true;
	private String sql0;
	private String sql1;
	private String sql2;

	public ReportImpl() 
	{
		factory = HibernateUtil.getSessionFactory();
		if (isDebug) {
			sql0 = "select Farmer.name as \"farmerName\", Product.name as \"productName\", SupplyDetails.qnt as \"qnt\", SupplyDetails.sPrice as \"sPrice\" from Farmer, Product, Supply, SupplyDetails where (Farmer.id = Supply.idFarmer) and (Supply.id = SupplyDetails.idSupply) and (Product.id = SupplyDetails.idProduct) and (Supply.sDate = \"2017-01-18\");";
			sql1 = "select Buyer.name as \"buyerName\", Product.name as \"productName\", PurchaseDetails.qnt as \"qnt\", PurchaseDetails.pPrice as \"pPrice\" from Buyer, Product, PurchaseDetails, Purchase, SupplyDetails where (Buyer.id = Purchase.idBuyer) and (Purchase.id = PurchaseDetails.idPurchase) and (PurchaseDetails.idSupplyDetails = SupplyDetails.id) and (SupplyDetails.idProduct = Product.id) and (Purchase.pDate = \"2017-01-18\");";
			sql2 = "select sum(total) as \"sumTotalPrice\" from Purchase where pDate = \"2017-01-18\";";
		} else {
			sql0 = "select Farmer.name as \"farmerName\", Product.name as \"productName\", SupplyDetails.qnt as \"qnt\", SupplyDetails.sPrice as \"sPrice\" from Farmer, Product, Supply, SupplyDetails where (Farmer.id = Supply.idFarmer) and (Supply.id = SupplyDetails.idSupply) and (Product.id = SupplyDetails.idProduct) and (Supply.sDate = current_date());";
			sql1 = "select Buyer.name as \"buyerName\", Product.name as \"productName\", PurchaseDetails.qnt as \"qnt\", PurchaseDetails.pPrice as \"pPrice\" from Buyer, Product, PurchaseDetails, Purchase, SupplyDetails where (Buyer.id = Purchase.idBuyer) and (Purchase.id = PurchaseDetails.idPurchase) and (PurchaseDetails.idSupplyDetails = SupplyDetails.id) and (SupplyDetails.idProduct = Product.id) and (Purchase.pDate = current_date());";
			sql2 = "select sum(total) as \"sumTotalPrice\" from Purchase where pDate = current_date();";
		}
	}
	
	private List getReportCommonStructureResult(String sql) {
		Transaction tx = null;
		List results = null;
		try(Session session = factory.getCurrentSession()) {
			tx = session.beginTransaction();
			SQLQuery query = session.createNativeQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			results = query.list();
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

}

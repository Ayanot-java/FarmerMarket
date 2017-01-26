package market.controller;

import market.bean.*;
import market.dao.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Helen on 25.01.2017.
 */

@WebServlet(name = "PurchaseController", urlPatterns = {"/PurchaseController"}, description = "Purchase and Purchase details",
        initParams = {@WebInitParam(name="id",value="25"),@WebInitParam(name="name",value="PurchaseProcessing")})

public class PurchaseController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static final String HTML_START="<html><body>";
    public static final String HTML_END="</body></html>";

    private PurchaseDaoImpl purchase;
    private PurchaseDetailsDAOImpl details;
    private BuyerDAOImpl buyer;


    public PurchaseController() {
        purchase = new PurchaseDaoImpl();
        details = new PurchaseDetailsDAOImpl();
        buyer = new BuyerDAOImpl();


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        /*
        public void create(Buyer buyer); - POST
        public void create(Purchase purchase, Stock stock); - POST
        public void update(PurchaseDetails purchaseDetails); - POST
         */

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String forward="";
        String action = request.getParameter("action");
        if (action == null || action.equals("") )
            action = "listAllPurchases";

        switch (action) {
            case "deletePurchase" : {
                purchase.delete(Integer.parseInt(request.getParameter("id")));
                break;
            }
            case "deleteDetails" : {
                details.delete(Integer.parseInt(request.getParameter("id")));
                break;
            }
            case "listAllPurchases" : {
                List<Purchase> purchaseList = purchase.listAll();
                request.setAttribute("result", purchaseList);  // result - название листа в методе в PurchaseDaoImpl
                RequestDispatcher rd = request.getRequestDispatcher("/purchaseList.jsp");
                rd.forward(request, response);
                break;
            }
            case "listAllDetails" : {
                List<PurchaseDetails> detailsList = details.listAll();
                request.setAttribute("result", detailsList);
                RequestDispatcher rd = request.getRequestDispatcher("/detailsList.jsp");
                rd.forward(request, response);
                break;
            }
            case "findAllByBuyer" : {
                HttpSession session = request.getSession();
                Integer buyerId = (Integer)session.getAttribute("buyerId");
                List<Purchase> listByBuyer = purchase.findAllByBuyer(buyer.read(buyerId));
                request.setAttribute("result", listByBuyer);
                RequestDispatcher rd = request.getRequestDispatcher("/purchaseList.jsp");
                rd.forward(request, response);
                break;
            }
            case "findAllByPurchase" : {
                HttpSession session = request.getSession();
                Integer purchaseId = (Integer)session.getAttribute("purchaseId");
                List<PurchaseDetails> listByPurchase = details.findAllByPurchase(purchase.read(purchaseId));
                request.setAttribute("result", listByPurchase);
                RequestDispatcher rd = request.getRequestDispatcher("/detailsList.jsp");
                rd.forward(request, response);
                break;
            }
            case "findPurchase" : {
                HttpSession session = request.getSession();
                Integer purchaseId = (Integer)session.getAttribute("purchaseId");
                Purchase p = purchase.read(purchaseId);
                request.setAttribute("purchase", p);
                RequestDispatcher rd = request.getRequestDispatcher("/purchase.jsp");
                rd.forward(request, response);
                break;
            }
            case "findDetails" : {
                HttpSession session = request.getSession();
                Integer detailsId = (Integer)session.getAttribute("detailsId");
                PurchaseDetails d = details.read(detailsId);
                request.setAttribute("purchase", d);
                RequestDispatcher rd = request.getRequestDispatcher("/purchase.jsp");
                rd.forward(request, response);
                break;
            }



    }

    /*
    public void create(Buyer buyer); - POST
    public void delete(Integer id); - VV
    public List<Purchase> listAll(); - VV
    public List<Purchase> findAllByBuyer(Buyer buyer); - VV
    public Purchase read(Integer id); - VV
     */

    /*
    public void create(Purchase purchase, Stock stock); - POST
    public PurchaseDetails read(Integer id); - VV
    public void update(PurchaseDetails purchaseDetails); - POST
    public void delete(Integer id); - VV
    public List<PurchaseDetails> listAll(); - VV
    public List<PurchaseDetails> findAllByPurchase(Purchase purchase); - VV
     */


}}

package market.controller;

import market.bean.Farmer;
import market.bean.Product;
import market.bean.Supply;
import market.bean.SupplyDetails;
import market.dao.*;
import org.hibernate.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Tane4ka on 25.01.2017.
 */
@WebServlet(name = "SupplyController")
public class SupplyController extends HttpServlet {

    private FarmerDAO farmerDAO;
    private ProductDAO productDAO;
    private SupplyDao supplyDao;
    private SupplyDetailsDao supplyDetailsDao;

    public SupplyController() {
        farmerDAO = new FarmerDAOImpl();
        productDAO = new ProductDAOImpl();
        supplyDao = new SupplyDaoImpl();
        supplyDetailsDao = new SupplyDetailsDaoImpl();
    }

    private static final String ACTION_NEW_SUPPLY = "newSupply";
    private static final String LIST_ALL_DETAILS = "/supplyDetails.jsp";


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action").toLowerCase();

        switch (action) {
            case ACTION_NEW_SUPPLY:
                HttpSession session = request.getSession();
                Integer farmerId = Integer.parseInt((String) session.getAttribute("supplyId"));
                Integer supplyId = Integer.parseInt((String) session.getAttribute("supplyId"));
                Integer ptype = Integer.parseInt((String) session.getAttribute("ptype"));
                Integer pId = Integer.parseInt((String) session.getAttribute("pname"));
                Float qnt = Float.parseFloat((String) session.getAttribute("qnt"));
                Float price = Float.parseFloat((String) session.getAttribute("price"));

                Supply supply = null;

                if (supplyId == null) {
                    Farmer farmer = farmerDAO.read(farmerId);
                    supply = supplyDao.create(farmer);
                    session.setAttribute("supplyId", supply.getId());
                    SupplyDetails supplyDetails = supplyDetailsDao.create(qnt, price, pId, supply);
                }
                else {
                    supply = supplyDao.read(supplyId);
                }
                forward = LIST_ALL_DETAILS;
                request.setAttribute("supplyDetails", supplyDetailsDao.read(supply));
                break;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }
}

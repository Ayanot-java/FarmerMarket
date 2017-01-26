package market.controller;

import com.mysql.fabric.Response;
import market.bean.Farmer;
import market.dao.FarmerDAO;
import market.dao.FarmerDAOImpl;

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
 * Created by hp comp on 23.01.2017.
 */
@WebServlet(name = "FarmerController", urlPatterns = {"/FarmerController"})
public class FarmerController extends HttpServlet {
    FarmerDAO farmerDAO;

    public FarmerController() {
        farmerDAO = new FarmerDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("farmer", farmerDAO.read(id));
        RequestDispatcher update = request.getRequestDispatcher("updateFarmer.jsp");
        update.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("Farmers", farmerDAO.listAll());
        RequestDispatcher view = request.getRequestDispatcher("/listFarmers.jsp");
        view.forward(request, response);
    }
}

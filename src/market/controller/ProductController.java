package market.controller;

import market.bean.Product;
import market.dao.ProductDAO;
import market.dao.ProductDAOImpl;
import market.dao.ProductTypeDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by j2ck on 25/01/17.
 */
@WebServlet(name = "ProductController", urlPatterns = {"/ProductController"})
public class ProductController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("productName");
        String productType = request.getParameter("productType");

//        Part filePart = request.getPart("imageFile"); // Retrieves <input type="file" name="file">
//        String fileName = Paths.get(filePart.getName()).toString(); // MSIE fix.
//        InputStream fileContent = filePart.getInputStream();
//        FileOutputStream fop = null;
//        fop = new FileOutputStream(new File("/images/" + productName + ".jpg"));

//        int read = 0;
//        byte[] bytes = new byte[1024];
//        while ((read = fileContent.read(bytes)) != -1) {
//            fop.write(bytes, 0, read);
//        }
//        fileContent.close();
//        fop.close();

//        ProductDAO productDAO = new ProductDAOImpl();
//        ProductTypeDAO productTypeDAO = new ProductTypeDAOImlp();
//        productDAO.create(productName, productTypeDAO.get(productType));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ProductDAO productDAO = new ProductDAOImpl();
        ArrayList<Product> products = productDAO.listAll();
        session.setAttribute("listOfProducts", products);
        RequestDispatcher view = request.getRequestDispatcher("newProduct.jsp");
        view.forward(request, response);
    }
}

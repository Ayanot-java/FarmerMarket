package market.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import market.dao.ReportImpl;

@WebServlet("/ReportController")
public class ReportController extends HttpServlet {
	
	private ReportImpl report;
	
	public ReportController() {
		super();
		report = new ReportImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("report");
		if (null == action)
			action = "report0";
		List results = null;
		String forward = "";
		switch (action) {
			case "report0":
			{
				results = report.getReport0();
				forward = "/viewReport0.jsp";
				break;
			}
			case "report1":
			{
				results = report.getReport1();
				forward = "/viewReport1.jsp";
				break;
			}
			case "report2":
			{
				results = report.getReport2();
				forward = "/viewReport2.jsp";
				break;
			}
			default:
			{
				results = report.getReport0();
				forward = "/viewReport0.jsp";
				break;
			}
		}
		request.setAttribute("reportData", results);
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}

package market.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import market.bean.User;
import market.dao.UserDAO;
import market.dao.UserDAOImpl;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	private static final String LIST_USERS = "/listUsers.jsp";
	private static final String WRONG_LOGIN = "/wrongLogin.html";
	private static final String ACTION_NEW_USER = "newUser";
	private static final String ACTION_LOGIN = "login";  
	
	private UserDAO userDao; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() 
    {
        super();
        userDao = new UserDAOImpl();        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String forward="";
		String action = request.getParameter("action").toLowerCase();
		String username="";
		String password = "";
		HttpSession session = request.getSession();
		User user = null;
		
		switch(action)
		{
			case ACTION_NEW_USER:
				username = request.getParameter("username");
				password = request.getParameter("password");
				try {
					userDao.create(username, password);
					//TODO: Handle "username is in use" case
				} catch (Exception e) {
					e.printStackTrace();
				}
				user = userDao.read(username);
				session.setAttribute("username", username);
				session.setAttribute("userId", user.getId());	
				forward = LIST_USERS;
				request.setAttribute("users", userDao.listAll());
			break;
			case ACTION_LOGIN:
				username = request.getParameter("username");
				password = request.getParameter("password");
				user = userDao.read(username);
				
				if(user != null)
				{					
					session.setAttribute("username", username);
					session.setAttribute("userId", user.getId());					
				}
				else
				{
					forward = WRONG_LOGIN;
				}
				break;
			default:
				forward = LIST_USERS;
				request.setAttribute("users", userDao.listAll());
				
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response); 
	}

}

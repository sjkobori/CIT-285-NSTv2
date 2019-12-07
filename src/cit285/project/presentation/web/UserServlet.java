 package cit285.project.presentation.web;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cit285.project.config.BookSystemConfig;
import cit285.project.domain.User;
import cit285.project.services.UserServicesAPI;

/**
 * Servlet implementation class PaymentsServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServicesAPI userServices;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	try{
			//System.out.println("Configuring services...");
			BookSystemConfig.configureServices();
		}
		catch(Exception e){}
		//System.out.println("Getting payments services...");
		userServices = BookSystemConfig.getUserServices();
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		HttpSession session = request.getSession();
		String source = request.getParameter("source");
		
		if (source.equals("welcome")){
			
			
			
			// Add attribute to the session
			
			
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/welcome.jsp").forward(request, response);
		}
		else if (source.equals("adminbooklist")) {

			ArrayList<User> users = null;
			users = userServices.getUsers();
			session.setAttribute("users",users);
			System.out.println("Going to User List");
			request.getRequestDispatcher("/WEB-INF/jsp/UserList.jsp").forward(request, response);
			
		}
		else{
			session.setAttribute("Error","Unknown source!");
			System.out.println("UserServlet");
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		}
	}
}


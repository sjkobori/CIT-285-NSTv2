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
import cit285.project.domain.LineItem;
import cit285.project.services.LoginServices;
import cit285.project.services.LoginServicesAPI;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginServicesAPI loginServices;

	public void init() {
		loginServices = new LoginServices();
		try{
			//System.out.println("Configuring services...");
			BookSystemConfig.configureServices();
		}
		catch(Exception e){}
		//System.out.println("Getting payments services...");
		loginServices = BookSystemConfig.getLoginServices();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int loginStatus = 0;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String source = request.getParameter("source");
		HttpSession session = request.getSession();
		
		if (source.equals("login")) {
		
		loginStatus = loginServices.loginUser(username, password);

		session.setAttribute("admin", false);
		if (loginStatus == 1) { //user login
			System.out.println("User logged in...");
			if (session.getAttribute("username") != null && !session.getAttribute("username").equals(username)) {
				session.setAttribute("cart", null);
				//session.invalidate(); //clears session
				//session = request.getSession();
			}
			session.setAttribute("username", username);
			
			// response.sendRedirect("/BookServlet");
			//Redirect to initializeinvoice
			getServletContext().getRequestDispatcher("/initializeinvoice").forward(request, response);
			
		} else if (loginStatus == 2) { //admin login
			System.out.println("Admin logged in...");
			//go to admin page
			session.setAttribute("username", username);
			session.setAttribute("admin", true);
			//getServletContext().getRequestDispatcher("adminhome").forward(request, response);
			getServletContext().getRequestDispatcher("/getbooks").forward(request, response);
		} else { //not successful login
			System.out.println("Failed log in...");
			session.setAttribute("username", username);
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		}
		} else {
			session.setAttribute("Error","Unknown source!");
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		}

	}
}
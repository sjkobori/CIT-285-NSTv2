package cit285.project.presentation.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cit285.project.services.LoginServices;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginServices loginService;

	public void init() {
		loginService = new LoginServices();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int x = 0;
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		x = loginService.loginUser(username, password);

		if (x == 1) { //user login
			// System.out.println(x);
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			// response.sendRedirect("/BookServlet");
			getServletContext().getRequestDispatcher("/BookServlet").forward(request, response);
		} else if (x == 2) { //admin login
			System.out.println("It's an admin");
			//go to admin page
		} else { //not successful login
			HttpSession session = request.getSession();
			session.setAttribute("user", username);
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		}

	}
}
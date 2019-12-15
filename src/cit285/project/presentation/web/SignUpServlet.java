package cit285.project.presentation.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cit285.project.config.BookSystemConfig;
import cit285.project.domain.Address;
import cit285.project.domain.Email;
import cit285.project.domain.User;
import cit285.project.services.SignUpServicesAPI;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SignUpServicesAPI signUpServices;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		try {
			// System.out.println("Configuring services...");
			BookSystemConfig.configureServices();
		} catch (Exception e) {
		}
		// System.out.println("Getting payments services...");
		signUpServices = BookSystemConfig.getSignUpServices();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String source = request.getParameter("source");

		if (source.equals("signUp")) {
			// make a user
			// add try block
			User user = new User(); //creates user obj

			try { 
				//sets user data
				user.setUserName(request.getParameter("username"));
				user.setPassword(request.getParameter("password"));
				user.setFirstName(request.getParameter("firstname"));
				user.setLastName(request.getParameter("lastname"));
				user.setCompanyName(request.getParameter("companyname"));

				//sets email data
				Email email = new Email();
				email.setEmailAddress(request.getParameter("email"));

				//sets address data
				Address address = new Address();
				address.setCity(request.getParameter("city"));
				address.setStreet(request.getParameter("street"));
				address.setZipcode(request.getParameter("zipcode"));
				address.setState(request.getParameter("state"));
				address.setCountry(request.getParameter("country"));

				if (!request.getParameter("confirmpassword").equals(user.getPassword())) {
					throw new IllegalArgumentException("Passwords Don't Match!");
				}
				
				signUpServices.signUp(user, email, address);
				session.setAttribute("username", user.getUserName()); //set username
				session.setAttribute("error", null);

			} catch (IllegalArgumentException ex) {
				session.setAttribute("error", ex.getMessage());
				getServletContext().getRequestDispatcher("/WEB-INF/jsp/SignUp.jsp").forward(request, response);
			}

			getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		} else {
			session.setAttribute("Error", "Unknown source!");
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		}
	}

}

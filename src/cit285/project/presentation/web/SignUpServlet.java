package cit285.project.presentation.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cit285.project.config.BookSystemConfig;
import cit285.project.config.SignUpSystemConfig;
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
    	try{
			//System.out.println("Configuring services...");
			SignUpSystemConfig.configureServices();
		}
		catch(Exception e){}
		//System.out.println("Getting payments services...");
		signUpServices = SignUpSystemConfig.getSignUpServices();
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
				
				if (source.equals("signup")){
					//make a user
					//add try block
					//User user = new User();
					//user.setFirstName(request.getParameter("firstname"));
					//user.setLastName(request.getParameter("lastname"));
					//user.setCompanyName(request.getParameter("companyname"));
					
					//Email email = new Email();
					//email.setEmailAddress(request.getParameter("email"));
					
					//Address address = new Address();
					//address.setStreet(request.getParameter("street"));
					//address.setCity(request.getParameter("city"));
					//address.setZipcode(request.getParameter("zipcode"));
					//try {
					User user = new User();
					user.setFirstName("Ask");
					user.setLastName("Jeeves");
					user.setCompanyName("ElonMusk Sucks");
					
					Email email = new Email();
					email.setEmailAddress("coolguy@hotmail.com");
					
					Address address = new Address();
					address.setStreet("forest street");
					address.setCity("Chicago");
					address.setZipcode("33333");
					/*if (signUpServices == null) {
						System.out.println("signupservices is null");	
					}
					} catch (NullPointerException ex){
						System.out.println("Null pointer exception...");
					}
					System.out.println("Passing signup data to services");*/
					
					signUpServices.signUp(user, email, address);
					//ArrayList<String> users = null;
					
					
					//users = userServices.getUsers();
					
					// Add attribute to the session
					//session.setAttribute("users",users);
					
					//getServletContext().getRequestDispatcher("/WEB-INF/jsp/welcome.jsp").forward(request, response);
				}
				else{
					session.setAttribute("Error","Unknown source!");
					getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
				}
	}

}

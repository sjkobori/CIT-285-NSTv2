package cit285.project.presentation.web;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cit285.project.config.BookSystemConfig;
import cit285.project.services.InvoiceServices;
import cit285.project.services.InvoiceServicesAPI;
import cit285.project.services.LoginServices;
import cit285.project.services.LoginServicesAPI;

/**
 * Servlet implementation class InitializeInvoiceServlet
 */
@WebServlet("/initializeinvoice")
public class InitializeInvoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InvoiceServicesAPI invoiceServices;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitializeInvoiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		invoiceServices = new InvoiceServices();
		try{
			//System.out.println("Configuring services...");
			BookSystemConfig.configureServices();
		}
		catch(Exception e){}
		//System.out.println("Getting payments services...");
		invoiceServices = BookSystemConfig.getInvoiceServices();
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
		if (source.equals("login")) {
			//if (session.getAttribute(""))
			
			session.setAttribute("invoice", 
					invoiceServices.initializeInvoice(request.getParameter("username")));
			System.out.println(session.getAttribute("invoice"));
			System.out.println("Looking good!");
			// clear session data
			//getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			request.getRequestDispatcher("/booklist").forward(request, response);
		}
		
		else { //go to error page
			System.out.println("ELSE");
		}
		
		
	}

}

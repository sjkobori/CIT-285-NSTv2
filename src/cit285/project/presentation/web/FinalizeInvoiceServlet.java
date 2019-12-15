package cit285.project.presentation.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cit285.project.config.BookSystemConfig;
import cit285.project.domain.LineItem;
import cit285.project.services.InvoiceServices;
import cit285.project.services.InvoiceServicesAPI;
import cit285.project.services.LoginServices;
import cit285.project.services.LoginServicesAPI;

/**
 * Servlet implementation class InitializeInvoiceServlet
 */
@WebServlet("/finalizeinvoiceservlet")
public class FinalizeInvoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InvoiceServicesAPI invoiceServices;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalizeInvoiceServlet() {
        super();
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
		//doGet(request, response);
		
		HttpSession session = request.getSession();
		String source = request.getParameter("source");
		//Take parameter source and check to see what the button is.
		if (source.equals("cart")) {
			
			System.out.println(session.getAttribute("invoice"));
			//if it successfully makes an invoice
			
			//if cart isn't null and finalize invoice is successful
			if(session.getAttribute("cart") != null &&
					invoiceServices.finalizeInvoice((int)session.getAttribute("invoice"), Double.parseDouble(request.getParameter("cartTotal")))) { 
				session.setAttribute("cart", new ArrayList<LineItem>());
				// make new cart
				request.getRequestDispatcher("/initializeinvoice").forward(request, response);
			} else {
				// clear session data (move to logout)
				request.getRequestDispatcher("/WEB-INF/jsp/cart.jsp").forward(request, response);
			}

		}
		
		else { //go to error page
			session.setAttribute("Error","Unknown source!");
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		}
		
		
	}

}

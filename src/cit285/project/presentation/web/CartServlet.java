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
import cit285.project.services.InvoiceServices;
import cit285.project.services.InvoiceServicesAPI;
import cit285.project.services.LoginServices;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InvoiceServicesAPI invoiceServices;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String source = request.getParameter("source");
		if (source.equals("booklist") || source.equals("cart")) {
			// clear session data
			//retrieve cart
			//call cart services
			ArrayList<LineItem> cart = null; //create list to hold cart
			
			
			cart = (ArrayList<LineItem>) session.getAttribute("cart");
			
			
			//cart = invoiceServices.getCart((int)session.getAttribute("invoice")); //fill with users current cart
			for (LineItem item : cart) {
				System.out.println(item.getLineItemId());
			}
			// Add attribute "cart" to the session
			session.setAttribute("cart", cart);
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/cart.jsp").forward(request, response);
		}
		//If the source is continue shopping return the user to the booklist
		else if (source.contentEquals("continueShopping")) {
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/booklist.jsp").forward(request, response);
		}
		else {
			session.setAttribute("Error","Unknown source!");
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		}
	}

}

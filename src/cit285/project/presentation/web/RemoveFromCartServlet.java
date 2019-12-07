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
import cit285.project.domain.Book;
import cit285.project.domain.LineItem;
import cit285.project.services.BookServicesAPI;
import cit285.project.services.InvoiceServicesAPI;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/removefromcart")
public class RemoveFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InvoiceServicesAPI invoiceServices;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveFromCartServlet() {
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
		// redirect/cart

		HttpSession session = request.getSession();
		String source = request.getParameter("source");
		
		if (source.equals("cart")) {
			// clear session data
			ArrayList<LineItem> cart = null;
			int cartNumber = Integer.parseInt(request.getParameter("book"));
			cart = (ArrayList<LineItem>) session.getAttribute("cart");
			
			System.out.println(cartNumber);
			LineItem item = new LineItem();
			item = cart.get(cartNumber);
			
			//if this is successful (add a boolean for the future)
			invoiceServices.removeFromCart(item); // send lineItem info to cart (contains invoice id and bookid)
			//when lineItem is deleted, remove it from the array list
			cart.remove(cartNumber);
			session.setAttribute("cart", cart);
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/cart.jsp").forward(request, response);

		} else { // invalid source
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		}
	}

}

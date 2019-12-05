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
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InvoiceServicesAPI invoiceServices;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToCartServlet() {
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
		System.out.println("inside inspect book servlet");
		String source = request.getParameter("source");
		if (source.equals("booklist")) {
			// clear session data
			ArrayList<Book> books = null;
			int bookNumber = Integer.parseInt(request.getParameter("book"));
			books = (ArrayList<Book>) session.getAttribute("books");
			
			LineItem item = new LineItem();
			item.setBookId(books.get(bookNumber).getBookid());
			item.setInvoiceId((int) session.getAttribute("invoice"));
			item.setQuantity(1);
			// Add attribute to the session
			invoiceServices.addToCart(item); //send lineItem info to cart (contains invoice id and bookid)
			//request.setAttribute("book", books.get(bookNumber));
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/booklist.jsp").forward(request, response);
		}
		else if (source.equals("inspectbook")) {
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/inspectBook.jsp").forward(request, response);
		}
		else {
			System.out.println("ELSE");
		}
	}

}

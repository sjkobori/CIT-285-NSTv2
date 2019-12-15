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
		
		if (source.equals("booklist")) {
			ArrayList<Book> books = null; //creates list to hold books
			int bookNumber = Integer.parseInt(request.getParameter("bookNumber")); //gets bookIndex
			books = (ArrayList<Book>) session.getAttribute("books"); //gets booklist from session
			
			LineItem item = new LineItem(); //creates a line item
			item.setBookId(books.get(bookNumber).getBookid()); //sets book id from selected book
			item.setInvoiceId((int) session.getAttribute("invoice")); //gets invoice id from active invoice
			//gets cart from session
			ArrayList<LineItem> cart = (ArrayList<LineItem>) session.getAttribute("cart");			
			
			addToCart(cart, item); //adds item to cart
			
			//update cart in session
			session.setAttribute("cart", cart);
			//returns to booklist
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/booklist.jsp").forward(request, response);
		}
		//if the source is inspectBook
		else if (source.equals("inspectBook")) {
			LineItem item = new LineItem(); //creates new item
			Book book = (Book) session.getAttribute("book"); //gets current book from session
			item.setBookId(book.getBookid()); 
			item.setInvoiceId((int) session.getAttribute("invoice")); //sets invoice id to active invoice
			//gets cart from session
			ArrayList<LineItem> cart = (ArrayList<LineItem>) session.getAttribute("cart");	
			
			addToCart(cart, item); //adds item to cart
			// Add attribute to the session
			//invoiceServices.addToCart(item); //send lineItem info to cart (contains invoice id and bookid)
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/inspectBook.jsp").forward(request, response);
		}
		else {
			session.setAttribute("Error","Unknown source!");
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		}
	}

	public void addToCart(ArrayList<LineItem> cart, LineItem item) {
		boolean isBookInCart = false; //flag for checking if book is in cart already
		
		for (LineItem items : cart) {  //iterates though all items in cart
			//if bookid matchs
			//add one to quantity
			if (items.getBookId() == item.getBookId()) {
				items.setQuantity(items.getQuantity() + 1);
				isBookInCart = true;
				break;
			}
		}
		if (!isBookInCart) { //if book not in cart
			item.setQuantity(1);
			cart.add(item); //add it to cart
		}
	}
	
}

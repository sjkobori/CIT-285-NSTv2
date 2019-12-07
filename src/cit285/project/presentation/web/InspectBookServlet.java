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
import cit285.project.services.BookServicesAPI;

/**
 * Servlet implementation class PaymentsServlet
 */
@WebServlet("/InspectBookServlet")
public class InspectBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookServicesAPI bookServices;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InspectBookServlet() {
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
		bookServices = BookSystemConfig.getBookServices();
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		HttpSession session = request.getSession();
		// int userId = session.getAttribute(arg0)
		String source = request.getParameter("source");
		System.out.println("inside inspect book servlet");
		if (source.equals("booklist") || source.equals("cart") || source.equals("adminHome")) {
			ArrayList<Book> books = null;
			// Book book = null;
			// try {
			books = (ArrayList<Book>) session.getAttribute("books");// session.getAttribute("book");
			// } catch (Exception ex) {
			// ex.printStackTrace();
			// }
			// Add attribute to the session
			// System.out.println(book);
			//FIX FIX FIX
			session.setAttribute("bookNumber", Integer.parseInt(request.getParameter("bookNumber")));
			session.setAttribute("book", books.get(Integer.parseInt(request.getParameter("bookNumber"))));
			if (source.equals("adminHome")) {
				getServletContext().getRequestDispatcher("/WEB-INF/jsp/updateBook.jsp").forward(request, response);
			} else {
				getServletContext().getRequestDispatcher("/WEB-INF/jsp/inspectBook.jsp").forward(request, response);
			}
		} else {
			session.setAttribute("Error", "Unknown source!");
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		}
	}
}

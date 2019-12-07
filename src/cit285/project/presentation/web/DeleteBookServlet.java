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
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookServicesAPI bookServices;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteBookServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		HttpSession session = request.getSession();
		String source = request.getParameter("source");

		if (source.equals("adminHome")) {
			ArrayList<Book> booklist = (ArrayList<Book>) session.getAttribute("books");
			int bookNumber = Integer.parseInt(request.getParameter("bookNumber"));

			// if this is successful (add a boolean for the future)
			bookServices.deleteBook(booklist.get(bookNumber).getBookid());

			// make sure book is now deleted
			// in admin page (when book is deleted, remove it from the array list)
			booklist.remove(bookNumber);
			session.setAttribute("books", booklist);
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/AdminPage.jsp").forward(request, response);
		} else {
			session.setAttribute("Error", "Unknown source!");
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		}
	}
}

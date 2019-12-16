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
import cit285.project.domain.Author;
import cit285.project.services.BookServicesAPI;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookServicesAPI bookServices;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateBookServlet() {
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

		if (source.equals("updateBook")) {
			Book tempbook = (Book) session.getAttribute("book"); //holds old book
			ArrayList<Author> authorlist = (ArrayList<Author>) session.getAttribute("authors");

			Book updatedBook = new Book(); //holds new book

			try {
				updatedBook.setBookid(tempbook.getBookid());
				updatedBook.setIsbn(request.getParameter("isbn"));
				updatedBook.setTitle(request.getParameter("title"));
				updatedBook.setEditor(request.getParameter("editor"));
				updatedBook.setEdition(request.getParameter("edition"));
				updatedBook.setYear(Integer.parseInt(request.getParameter("year")));
				updatedBook.setPrice(Double.parseDouble(request.getParameter("price")));
				updatedBook.setDescription(request.getParameter("description"));
				updatedBook.setImagepath(request.getParameter("imagepath"));

				// add selected author to book
				updatedBook.setAuthor(authorlist.get(Integer.parseInt(request.getParameter("authorindex"))));
				//updates book
				bookServices.updateBook(updatedBook);

				//gets book index from session
				int bookNumber = (int) session.getAttribute("bookNumber");
				//gets booklist from session
				ArrayList<Book> booklist = (ArrayList<Book>) session.getAttribute("books");
				booklist.set(bookNumber, updatedBook); // exchange new book at selected book index
				session.setAttribute("book", updatedBook);
				session.setAttribute("error", null);
			} catch (IllegalArgumentException ex) {
				session.setAttribute("error", ex.getMessage());
				getServletContext().getRequestDispatcher("/WEB-INF/jsp/updateBook.jsp").forward(request, response);
			} 

			getServletContext().getRequestDispatcher("/WEB-INF/jsp/adminHome.jsp").forward(request, response);
		} else if (source.equals("addAuthor")) { //coming from addAuthor page
			// make a user
			// add try block
			Author author = new Author();
			author.setAuthorfirstname(request.getParameter("authorfirstname"));
			author.setAuthorlastname(request.getParameter("authorlastname"));

			//try block
			bookServices.addAuthor(author); 

			getServletContext().getRequestDispatcher("/WEB-INF/jsp/AddBook.jsp").forward(request, response);
		} else {
			session.setAttribute("Error", "Unknown source!");
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		}
	}

}

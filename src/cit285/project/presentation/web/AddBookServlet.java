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
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookServicesAPI bookServices;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
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
		bookServices = BookSystemConfig.getBookServices();
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
				
				if (source.equals("addBook")){
					//make a user
					//add try block
					ArrayList<Author> authorlist = (ArrayList<Author>) session.getAttribute("authors");
					Book book = new Book();
					book.setIsbn(request.getParameter("isbn"));
					book.setTitle(request.getParameter("title"));
					book.setEditor(request.getParameter("editor"));
					book.setEdition(request.getParameter("edition"));
					book.setYear(Integer.parseInt(request.getParameter("year")));
					book.setPrice(Double.parseDouble(request.getParameter("price")));
					book.setDescription(request.getParameter("description"));
					book.setImagepath(request.getParameter("imagepath"));
					//sets author to selected author
					book.setAuthor(authorlist.get(Integer.parseInt(request.getParameter("authorindex"))));
					ArrayList<Book> booklist = (ArrayList<Book>) session.getAttribute("books");
					
					bookServices.addBook(book); //add new book in database
					booklist.add(book);
					session.setAttribute("books", booklist); //put updated list in session

					getServletContext().getRequestDispatcher("/WEB-INF/jsp/AddBook.jsp").forward(request, response);
				}
				else if (source.equals("addAuthor")){
					//make a user
					//add try block
					Author author = new Author();
					author.setAuthorfirstname(request.getParameter("authorfirstname"));
					author.setAuthorlastname(request.getParameter("authorlastname"));
					
					System.out.println("Adding Author, maybe...");
					bookServices.addAuthor(author);
					
					// Add attribute to the session
					//set login
					///session.setAttribute("users",users);
					
					getServletContext().getRequestDispatcher("/WEB-INF/jsp/AddBook.jsp").forward(request, response);
				}				
				else{
					session.setAttribute("Error","Unknown source!");
					getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
				}
	}

}

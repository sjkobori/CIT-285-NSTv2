package cit285.project.presentation.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cit285.project.config.BookSystemConfig;
import cit285.project.domain.Address;
import cit285.project.domain.Book;
import cit285.project.domain.Email;
import cit285.project.domain.User;
import cit285.project.services.AddBookServices;
import cit285.project.services.AddBookServicesAPI;
import cit285.project.services.SignUpServicesAPI;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddBookServicesAPI addBookServices;
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
		addBookServices = BookSystemConfig.getAddBookServices();
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
					Book book = new Book();
					book.setIsbn(request.getParameter("isbn"));
					book.setTitle(request.getParameter("title"));
					book.setEditor(request.getParameter("editor"));
					book.setEdition(request.getParameter("edition"));
					book.setYear(Integer.parseInt(request.getParameter("year")));
					System.out.println("Adding Book, maybe...");
					addBookServices.addBook(book);
					
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

package cit285.project.presentation.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/redirect/*")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RedirectServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
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
		System.out.println("inside redirect");
		String source = request.getParameter("source");
		HttpSession session = request.getSession();
		
		//if not signed in yet
		if (source.equals("SignUp")) {
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/signUp.jsp").forward(request, response);
		}// else if (!(boolean) session.getAttribute("admin")) { // if user is logged in

		//}

		// admin redirect //add admin userlist
		 else if (source.equals("login")) {
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		} else if (source.equals("cart")) {
			System.out.println("Going to booklist");
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/booklist.jsp").forward(request, response);
		} else if (source.equals("adminHome")) {
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/addBook.jsp").forward(request, response);
		} else if (source.equals("updateBook") || source.equals("userlist") || source.equals("addBook")) {
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/adminHome.jsp").forward(request, response);
			
		}
		else {
			session.setAttribute("Error", "Unknown source!");
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		}
	}

}

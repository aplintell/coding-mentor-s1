package coding.mentor.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coding.mentor.dao.BookDAO;
import coding.mentor.dao.CategoryDAO;
import coding.mentor.entity.Book;
import coding.mentor.entity.Category;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryDAO categoryDAO = new CategoryDAO();
	BookDAO bookDAO = new BookDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			// get Data from Model
			List<Category> categories = categoryDAO.getAllShowedCategories();
			// attach Data to request
			request.setAttribute("categories", categories);

			List<Book> books;
			// get book details
			// get parameter bookId -> get 1 BOOK
			String bookId = request.getParameter("bookId");
			// get books by category
			// get categoryId
			String categoryId = request.getParameter("categoryId");

			if (categoryId != null) {
				books = bookDAO.getBookByCategoryId(Long.parseLong(categoryId));
				request.setAttribute("books", books);
			} else if (bookId != null) {
				Book book = bookDAO.getBook(Integer.parseInt(bookId));
				request.setAttribute("book", book);
			} else {
				books = bookDAO.getAllBooks();
				request.setAttribute("books", books);
			}

			// send data to JSP
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

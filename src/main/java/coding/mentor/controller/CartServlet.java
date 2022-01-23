package coding.mentor.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coding.mentor.dao.BookDAO;
import coding.mentor.dto.CartDTO;
import coding.mentor.entity.Book;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BookDAO bookDAO = new BookDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// step get bookId from POST request
			String bookId = request.getParameter("bookId");
			// get book by bookID from DB
			Book book = bookDAO.getBook(Integer.parseInt(bookId));
			// get current cart from session
			CartDTO cart = (CartDTO) request.getSession().getAttribute("cart");
			// update cart -> add book to cart
			// check if book is exist in cart ??

			boolean isExist = false;
			for (Book bookInCart : cart.getBooks()) {
				if (bookId.equals(bookInCart.getId() + "")) {
					isExist = true;
				}
			}
			if (!isExist) {
				cart.getBooks().add(book);
			}
			// update cart to session
			request.getSession().setAttribute("cart", cart);

			response.sendRedirect("HomeServlet?bookId=" + bookId);

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

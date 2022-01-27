package coding.mentor.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coding.mentor.dao.BookDAO;
import coding.mentor.dao.OrderDAO;
import coding.mentor.dao.OrderDetailsDAO;
import coding.mentor.dto.CartDTO;
import coding.mentor.entity.Book;
import coding.mentor.entity.Order;
import coding.mentor.entity.OrderDetails;
import coding.mentor.entity.Student;
import conding.mentor.constant.Constant;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String CART_REQUEST_ACTION_VIEW = "VIEW";
	private final String CART_REQUEST_ACTION_ADD = "ADD";
	private final String CART_REQUEST_ACTION_CHECKOUT = "CHECKOUT";

	BookDAO bookDAO = new BookDAO();
	OrderDAO orderDAO = new OrderDAO();
	OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAO();

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
		try {
			String action = request.getParameter("action");

			switch (action) {
			case CART_REQUEST_ACTION_VIEW:
				// get cart from session
				request.setAttribute("showCart", true);

				// send data to JSP
				RequestDispatcher rd = request.getRequestDispatcher("HomeServlet");
				rd.forward(request, response);
				return;
			case CART_REQUEST_ACTION_ADD:
				// step get bookId from POST request
				String bookId = request.getParameter("bookId");
				// get book by bookID from DB
				Book book = bookDAO.getBook(Integer.parseInt(bookId));
				// get current cart from session
				CartDTO cart = (CartDTO) request.getSession().getAttribute(Constant.SESSION_CART);

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
				request.getSession().setAttribute(Constant.SESSION_CART, cart);

				response.sendRedirect("HomeServlet?bookId=" + bookId);
				return;
			case CART_REQUEST_ACTION_CHECKOUT:
				// insert new order to db (student_id)
				Student me = (Student) request.getSession().getAttribute("me");
				Order od = new Order();
				od.setStudentId(me.getId());

				// get order id from the inserted order
				int orderId = orderDAO.insert(od);

				// get books from session CART
				cart = (CartDTO) request.getSession().getAttribute(Constant.SESSION_CART);
				List<Book> books = cart.getBooks();

				// insert ORDERDETAILS to DB (order_id, book_id)
				OrderDetails orderDetails;
				for (Book b : books) {
					orderDetails = new OrderDetails(orderId, b.getId());
					orderDetailsDAO.insert(orderDetails);
				}

				// CLEAR CART
				cart.setBooks(new ArrayList<Book>());
				request.getSession().setAttribute(Constant.SESSION_CART, cart);
				response.sendRedirect("HomeServlet");
				return;
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
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

	}

}

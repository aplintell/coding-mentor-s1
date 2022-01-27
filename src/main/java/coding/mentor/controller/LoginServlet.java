package coding.mentor.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coding.mentor.dao.StudentDAO;
import coding.mentor.dto.CartDTO;
import coding.mentor.entity.Student;
import conding.mentor.constant.Constant;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDAO studentDAO = new StudentDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");
		if (command == null) {
			response.sendRedirect("login.jsp");
			return;
		}

		if (command.equals("logout")) {
			HttpSession session = request.getSession();
			session.removeAttribute("me");
			response.sendRedirect("HomeServlet");
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// go to DB coding_mentor -> table student -> select Student by email = username
		// and password = pasword
		// Return 1 record -> (id, first_name, last_name, email, password)
		// DAO -> collect record db return -> wrap into Entity
		// response to Home.jsp if login success
		// response to login.jsp if login fail

		try {
			Student student = studentDAO.getStudentByEmailAndPassword(username, password);
			if (student == null) {
				// login fail
				response.sendRedirect("LoginServlet");
			} else {
				// login success
				HttpSession session = request.getSession();
				session.setAttribute("me", student);
				session.setAttribute(Constant.SESSION_CART, new CartDTO(new ArrayList<>()));
				response.sendRedirect("HomeServlet");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

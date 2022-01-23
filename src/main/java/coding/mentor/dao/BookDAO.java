package coding.mentor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coding.mentor.constant.Constant;
import coding.mentor.db.DBUtil;
import coding.mentor.entity.Book;
import coding.mentor.entity.Category;

public class BookDAO {

	public List<Book> getAllBooks() throws SQLException {

		// access to database to get all Books.
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Book book = null;
		List<Book> books = new ArrayList<Book>();

		try {
			// make connection to Mysql
			conn = DBUtil.makeConnection();

			String sql = "SELECT * FROM book";

			// ps -> contain SQL + parameter values
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			// rs -> many records
			while (rs.next()) {
				book = new Book();
				book.setId(rs.getLong("id"));
				book.setName(rs.getString("name"));
				book.setStock(rs.getInt("stock"));
				book.setDescription(rs.getString("description"));
				book.setCategoryId(rs.getLong("category_id"));
				books.add(book);
			}
			return books;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

		return null;
	}

	public List<Book> getBookByCategoryId(long categoryId) throws SQLException {

		// access to database to get all Books.
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Book book = null;
		List<Book> books = new ArrayList<Book>();

		try {
			// make connection to Mysql
			conn = DBUtil.makeConnection();

			String sql = "SELECT * FROM book WHERE category_id = ?";

			// ps -> contain SQL + parameter values
			ps = conn.prepareStatement(sql);
			ps.setLong(1, categoryId);

			rs = ps.executeQuery();

			// rs -> many records
			while (rs.next()) {
				book = new Book();
				book.setId(rs.getLong("id"));
				book.setName(rs.getString("name"));
				book.setStock(rs.getInt("stock"));
				book.setDescription(rs.getString("description"));
				book.setCategoryId(rs.getLong("category_id"));
				books.add(book);
			}
			return books;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

		return null;
	}

	public Book getBook(int id) throws SQLException {
		// access to database to get all Books.
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Book book = null;

		try {
			// make connection to Mysql
			conn = DBUtil.makeConnection();

			String sql = "SELECT * FROM book WHERE id = ?";

			// ps -> contain SQL + parameter values
			ps = conn.prepareStatement(sql);
			ps.setLong(1, id);

			rs = ps.executeQuery();

			// rs -> 1 book
			if (rs.next()) {
				book = new Book();
				book.setId(rs.getLong("id"));
				book.setName(rs.getString("name"));
				book.setStock(rs.getInt("stock"));
				book.setDescription(rs.getString("description"));
				book.setCategoryId(rs.getLong("category_id"));

			}
			return book;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

		return null;
	}
}

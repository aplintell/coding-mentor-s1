package coding.mentor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coding.mentor.db.DBUtil;
import coding.mentor.entity.Category;

public class CategoryDAO {

	public List<Category> getAllShowedCategories() throws SQLException {

		// access to database to get All Categories with show = 1.
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Category category = null;
		List<Category> categories = new ArrayList<Category>();

		try {
			// make connection to Mysql
			conn = DBUtil.makeConnection();

			String sql = "SELECT * FROM category WHERE `show` = 1";

			// ps -> contain SQL + parameter values
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			// rs -> many records
			while (rs.next()) {
				category = new Category();
				category.setId(rs.getLong("id"));
				category.setName(rs.getString("name"));
				category.setShow(rs.getBoolean("show"));
				categories.add(category);
			}
			return categories;
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

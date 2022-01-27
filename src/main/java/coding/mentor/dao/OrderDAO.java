package coding.mentor.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import coding.mentor.db.DBUtil;
import coding.mentor.entity.Order;

public class OrderDAO {

	public int insert(Order order) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.makeConnection();

			// create sql for insert
			String sql = "INSERT INTO `order`(student_id, submit_date) value(?,?)";
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			// set params
			ps.setLong(1, order.getStudentId());
			ps.setDate(2, new Date(System.currentTimeMillis()));

			ps.execute();
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
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
	}

}

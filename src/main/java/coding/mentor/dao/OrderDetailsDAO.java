package coding.mentor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import coding.mentor.db.DBUtil;
import coding.mentor.entity.OrderDetails;

public class OrderDetailsDAO {

	public void insert(OrderDetails orderDetails) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.makeConnection();

			// create sql for insert
			String sql = "INSERT INTO `order_details`(order_id, book_id) value(?,?)";
			ps = conn.prepareStatement(sql);
			
			// set params
			ps.setLong(1, orderDetails.getOrderId());
			ps.setLong(2, orderDetails.getBookId());

			ps.execute();

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

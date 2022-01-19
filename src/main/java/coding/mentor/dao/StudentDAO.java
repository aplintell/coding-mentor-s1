package coding.mentor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import coding.mentor.db.DBUtil;
import coding.mentor.entity.Student;

public class StudentDAO {

	public Student getStudentByEmailAndPassword(String email, String password) throws SQLException {
		// access to database to get Student Record by Email and Password.
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student student = null;

		try {
			// make connection to Mysql
			conn = DBUtil.makeConnection();
			System.out.println("conn " + conn);

			String sql = "SELECT * FROM student WHERE email = ? AND password = ?";

			// ps -> contain SQL + parameter values
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);

			rs = ps.executeQuery();

			// rs -> 1/0 record
			if (rs.next()) {
				long id = rs.getLong("id");
				String fistName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				student = new Student(id, fistName, lastName, email, password);
			} else {
				return null;
			}
			return student;
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

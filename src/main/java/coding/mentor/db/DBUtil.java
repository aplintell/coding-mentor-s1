package coding.mentor.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	public static Connection makeConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coding_mentor", "admin",
					"admin");
			System.out.println(conn);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

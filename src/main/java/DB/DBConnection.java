package DB;

import java.sql.*;
public class DBConnection {
	public static Connection createConection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/location";
		String username = "root";
		String password = "sapassword";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return con;
	}
	
}

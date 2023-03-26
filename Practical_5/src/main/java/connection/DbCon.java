package connection;

import java.sql.*;

public class DbCon {
	private static Connection connection = null;
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if (connection == null) {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ketan?autoReconnect=true&useSSL=false","root","Ketan8@.2003");
	        System.out.print("Connected");
		}
		
		return connection;
	}
}

package assignment4.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil1 {

	// method to getting the connection setedUp
	public static Connection getConnection() throws SQLException {

		// Credentials to get the connections
		
		 String url="jdbc:mysql://localhost:3306/studentdatabase";
		String user = "root";
		String password = "Mysql@21";
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;

	}

	public void closeConnections(ResultSet resultSet, Statement statement, Connection connection) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

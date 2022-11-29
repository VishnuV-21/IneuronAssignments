package assignment4.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AllJdbcOpInOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;

//gets the connection here and assigning the connection to local variable connection

		try {
			connection = JdbcUtil1.getConnection();
			if (connection != null) {
				statement = connection.createStatement();
				if (statement != null) {
					String selectQuery = "Select s_id,Name,c_id,Age from student;";
					resultSet = statement.executeQuery(selectQuery);
					if (resultSet != null) {
						// processing result set
						System.out.println("S_Id\t\tName\t\tC_Id\t\tAge");
						System.out.println("-----------------------------------------------------");
						while (resultSet.next()) {
							Integer s_id = resultSet.getInt(1);
							String Name = resultSet.getString(2);
							Integer c_id = resultSet.getInt(3);
							Integer Age = resultSet.getInt(4);
							System.out.println(s_id + "\t\t" + Name + "\t\t" + c_id + "\t\t" + Age);
						}
					}
				}
			}

		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

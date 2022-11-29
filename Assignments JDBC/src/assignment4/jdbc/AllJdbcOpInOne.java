package assignment4.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AllJdbcOpInOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		Scanner sc=null;
		int s_id=0;
		String Name=null;
		int c_id=0;
		int Age=0;
		int userChoiceMain = 0;
//get the input from the user ,Which choice user wants
		userChoiceMain = JdbcUtil1.getUserInputForSelectQuery();
//gets the connection here and assigning the connection to local variable connection
		try {
			connection = JdbcUtil1.getConnection();
			if (connection != null) {
				statement = connection.createStatement();
				// here i used switch statement to perform the operation based on user's choice
				switch (userChoiceMain) {
				//1 is for Create/Insert Operation
				case 1: {
					if (statement != null) {
						 sc = new Scanner(System.in);
						System.out.println("Please provide the required details to create the query");
						System.out.println("Enter the Stud_Id :");
						 s_id = sc.nextInt();
						System.out.println("Enter the Stud_Name :");
						 Name = sc.next();
						System.out.println("Enter the Course_Id :");
						 c_id = sc.nextInt();
						System.out.println("Enter the Stud_Age :");
						 Age = sc.nextInt();

String InsertQuery = String.format("Insert into student values('%d','%s','%d','%d')",s_id,Name,c_id,Age);
//String.format("Insert into student values (`%d`,`%s`,`%d`,`%d`)",s_id,Name,c_id,Age);
					 			
						int rowCount = statement.executeUpdate(InsertQuery);
						// Getting the output for insert operation
						System.out.println("No of rows affected :: " + rowCount);
						//JdbcUtil1.closeConnections(resultSet, statement, connection);
					}
					break;
				}
				//2 is for Select/Read Operation
				case 2: {

					if (statement != null) {
						String selectQuery = "Select s_id,Name,c_id,Age from student;";
						resultSet = statement.executeQuery(selectQuery);
						if (resultSet != null) {
							// processing result set
							System.out.println("S_Id\t\tName\t\tC_Id\t\tAge");
							System.out.println("-----------------------------------------------------");
							while (resultSet.next()) {
								Integer stud_id = resultSet.getInt(1);
								String stud_Name = resultSet.getString(2);
								Integer course_id = resultSet.getInt(3);
								Integer stud_Age = resultSet.getInt(4);
								System.out.println(stud_id + "\t\t" + stud_Name + "\t\t" + course_id + "\t\t" + stud_Age);
							}
						}
					}
					break;
				}
				case 3: {
					break;
				}
				case 4: {
					break;
				}

				}

			}

		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sc!=null) {
				sc.close();
			}
		}

	}

}

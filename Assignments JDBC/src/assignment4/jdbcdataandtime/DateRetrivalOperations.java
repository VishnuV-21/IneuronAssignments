package assignment4.jdbcdataandtime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;



public class DateRetrivalOperations {
	public static void main(String[] args) {
		//All drivers and functions used 
		Connection connection =null;
		PreparedStatement prepStat= null;
		ResultSet resSet= null;
		Scanner sc= new Scanner(System.in);
		String Name=null;
		int Age=0;
		String Address= null;
		String Gender=null;
		String DOB=null;
		String DOJ=null;
		String DOM= null;
		
		
		

		try {
			connection =JdbcUtil1.getConnection();
			if(connection!=null ) {
				String selectQuery="Select Name,Age,Address,Gender,DOB,DOJ,DOM from dateofbirth where Name=?;";
				prepStat=connection.prepareStatement(selectQuery);
				if(prepStat!=null) {
					//we need to give the name for whose details we need to retrive
					System.out.println("Enter the name whose details you want to retrive :");
					 Name = sc.next();
					prepStat.setString(1, Name);
					resSet=prepStat.executeQuery();
					if(resSet!=null) {
						if(resSet.next()) {
							 Name = resSet.getString(1);
							Age=resSet.getInt(2);
							Address=resSet.getString(3);
							Gender=resSet.getString(4);
							java.sql.Date dob=resSet.getDate(5);
							java.sql.Date doj=resSet.getDate(6);
							java.sql.Date dom=resSet.getDate(7);
							SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
							DOB=sdf.format(dob);
							DOJ=sdf.format(doj);
							DOM=sdf.format(dom);
							
							//printing the values 
							System.out.println( "Name\t|Age\t|Address\t|Gender\t\t|DOB\t\t|DOJ\t\t|DOM\t");
							System.out.println(Name+"\t"+Age+"\t"+Address+"\t\t"+Gender+"\t\t"+DOB+"\t"+DOJ+"\t"+DOM);
						}
						
					}
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil1.closeConnections(resSet, prepStat, connection);
			
		}
	}
}

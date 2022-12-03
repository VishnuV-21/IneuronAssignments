package assignment4.jdbcdataandtime;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class DateOperations {
public static void main(String[] args) {
	String url="jdbc:mysql://localhost:3306/studentdob";
	String user="root";
	String password="Mysql@21";
	
	Connection connection =null;
	PreparedStatement preparedStatement= null;
	String studName=null;
	int studAge=0;
	String studAddress=null;
	String studGender=null;
	String dOB=null;
	String dOJ=null;
	String dOM=null;
	Scanner sc=new Scanner(System.in);
	 System.out.println("Enter the student Name");
	 studName=sc.next();
	 System.out.println("Enter the Student Age");
	 studAge=sc.nextInt();
	 System.out.println("Enter the Student Address");
	 studAddress=sc.next();
	 sc.next();
	 System.out.println("Enter the Student Gender");
	 studGender=sc.next();
	 
	 System.out.println("Enter the student Date Of Birth(dd-MM-yyyy)");
	 dOB=sc.next();
	 System.out.println("Enter the student Date Of Joining(MM-dd-yyyy)");
	 dOJ=sc.next();
	 System.out.println("Enter the student Date Of Marrage(yyyy-MM-dd)");//didn't know what DOM is for so kept as marrage
	 dOM=sc.next();
	 SimpleDateFormat sdf1= new SimpleDateFormat("dd-MM-yyyy");//This is the format for mysql
	 //for the above format the date will be stored in DB in the format yyyy-MM-dd
	try {
		connection=DriverManager.getConnection(url, user, password);
		 java.util.Date uDate1 = sdf1.parse(dOB);
		 java.util.Date uDate2 = sdf1.parse(dOB);
		 long utime1=uDate1.getTime();
		 long utime2=uDate2.getTime();
	 java.sql.Date sDOB =new java.sql.Date(utime1);
	 java.sql.Date sDOJ =new java.sql.Date(utime2);
	 java.sql.Date sDOM = java.sql.Date.valueOf(dOM);
		 if(connection !=null) {	 
			 String insertQuery="Insert into dateofbirth values (?,?,?,?,?,?,?);";
			preparedStatement= connection.prepareStatement(insertQuery);
			 if(preparedStatement!=null) {
				 preparedStatement.setString(1, studName);
				 preparedStatement.setInt(2, studAge);
				 preparedStatement.setString(3, studAddress);
				 preparedStatement.setString(4, studGender);
				 preparedStatement.setDate(5, sDOB);
				 preparedStatement.setDate(6, sDOJ);
				 preparedStatement.setDate(7,sDOM );
				int rCount=preparedStatement.executeUpdate(); 
				System.out.println("No of rows affected :: "+rCount); 
			 }
		 }
	} catch (SQLException | ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(connection !=null) {
				connection.close();
			}
			if(preparedStatement!=null) {
				preparedStatement.close();
			}
		}
		catch( SQLException se1) {
			se1.printStackTrace();
			
		}
		
		}
	
}
}

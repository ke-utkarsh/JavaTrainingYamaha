package jdbc_assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Connect {
	Connection cobj;
	Statement stmt1;
	ResultSet rs;
	public void con(){
		Scanner sc= new Scanner(System.in); 
		try {
			Class.forName("com.mysql.jdbc.Driver"); //Step 1
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//Step 2
			cobj=DriverManager.getConnection("jdbc:mysql://localhost/mysqldb","root","Root");
			//Step 3 and 4
			stmt1=cobj.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=stmt1.executeQuery("select * from jdbcassignment");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next()){
				System.out.println("Please Update record of :");
				System.out.println("Sap_id: "+rs.getInt("sap_id")+" Name: "+rs.getString("empname")+" Stream: "+rs.getString("stream"));
				System.out.println("Enter percentage: ");
				double percent=sc.nextDouble();
				rs.updateDouble("percentage",percent);
				rs.updateRow();
				System.out.println("Updated Record is: ");
				System.out.println("Sap_id: "+rs.getInt("sap_id")+" Name: "+rs.getString("empname")+" Stream: "+rs.getString("stream")+" Percentage: "+rs.getDouble("percentage"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

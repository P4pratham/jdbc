package jdbcPrc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDB {
	static Connection conn;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 try {Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testp", "beast", "beast");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 Scanner sc =new Scanner(System.in);
		 int ch;
		 do {
		 System.out.println("1.display 2.Insert ");
		 ch=sc.nextInt();

	

		switch (ch) {
		case 1:
			String query1="select * from test";
			try {
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(query1);
				while(rs.next()) {
					System.out.println("Rollno is : "+rs.getInt("id"));
					System.out.println("Name is : "+rs.getString("name"));
					//System.out.println("course is : "+rs.getString("course"));
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			break;
		case 2: 
			PreparedStatement pst=null;
			try {
				String query="insert into test(id,name) values(?,?)"; 
				pst=conn.prepareStatement(query);		
				
				System.out.println("enter roll no");
				int roll= sc.nextInt();
				System.out.println("enter name ");
				String name = sc.next();
				
				
				pst.setInt(1,roll);
				pst.setString(2, name);
				//pst.setString(3, course);
				
				int count =pst.executeUpdate();
				if(count>0)
					System.out.println("Data Inserted");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			break;
		default:
			System.out.println("Invalid input");
			break;
		}
} while (ch!=0);		

	}

}

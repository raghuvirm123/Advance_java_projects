package jdbcproj;

import java.sql.*;
import java.util.Scanner;

public class prepared_statement {
	public static void main(String[] args) 
	{

		String url = "jdbc:mysql://localhost:3306?user=root && password=root";

		String qry = "insert into tata.emp values(?,?,?)";
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id:");
		int id = sc.nextInt();
		System.out.println("enter name:");
		String ename = sc.next();
		System.out.println("enter sal:");
		double sal = sc.nextDouble();

		try 
		{
			// Class.forName("com.mysql.cj.jdbc.Driver");

			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("class laoded");

			Connection con = DriverManager.getConnection(url);
			System.out.println("coonection ectablisted");

			// Statement stmt=con.createStatement();
			PreparedStatement pstmt = con.prepareStatement(qry);
			System.out.println("platform created");

			pstmt.setInt(1, id);
			pstmt.setString(2, ename);
			pstmt.setDouble(3, sal);
			pstmt.execute();
			System.out.println("data inserted");

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}

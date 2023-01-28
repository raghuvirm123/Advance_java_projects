package jdbcproj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class insert_data1 {
	public static void main(String[] args)

	{
		String url = "jdbc:mysql://localhost:3306?user=root && password=root";
		String qry = "insert into tata.emp values(01,'akash',40000)";
		// String qry1="DELETE FROM tata.emp WHERE id=03";
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Dirver class loaded");

			Connection con = DriverManager.getConnection(url);
			System.out.println("connection with jdbc done");

			Statement stmt = con.createStatement();
			System.out.println("platform crated");

			stmt.execute(qry);
			System.out.println("data inserted");

		} 
		catch (Exception e)
		{
			System.out.println("Data not inserted");
		}

	}

}

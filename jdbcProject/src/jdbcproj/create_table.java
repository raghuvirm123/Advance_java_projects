package jdbcproj;
import java.sql.*;

public class create_table 
{
	public static void main(String[] args) 
	{
		String url="jdbc:mysql://localhost:3306?user=root && password=root";
		String qry="create table tata.emp (id int,ename varchar(20),sal double)";
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Dirver class loaded");
			
			Connection con=DriverManager.getConnection(url);
			System.out.println("connection with jdbc done");
			
			Statement stmt=con.createStatement();
			System.out.println("platform crated");
			
			stmt.execute(qry);
			System.out.println("table created");
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}


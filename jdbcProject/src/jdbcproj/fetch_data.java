package jdbcproj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class fetch_data {
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306?user=root && password=root";

		String qry = "select * from tata.emp where id=?";
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id:");
		int id = sc.nextInt();

		try {
			// Class.forName("com.mysql.cj.jdbc.Driver");

			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("class laoded");

			Connection con = DriverManager.getConnection(url);
			System.out.println("coonection ectablisted");

			// Statement stmt=con.createStatement();
			PreparedStatement pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int id1 = rs.getInt(1);
				String ename1 = rs.getString(2);
				Double sal1 = rs.getDouble(3);
				System.out.println(id1 + " " + ename1 + " " + sal1);
			} else {
				System.out.println("invalid input");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

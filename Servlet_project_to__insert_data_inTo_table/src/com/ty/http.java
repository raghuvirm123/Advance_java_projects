package com.ty;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class http extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		PrintWriter out = resp.getWriter();
		
		int id =Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("nm");
		//int sal=Integer.parseInt(req.getParameter("sal"));
		double sal = Double.parseDouble(req.getParameter("sal"));
		
     	out.println(id+" "+name+" "+sal);
		
		String url = "jdbc:mysql://localhost:3306?user=root&password=root";
		String qry = "insert into employee.employeeinfo values(?, ?, ?)";
		Connection con = null;
		PreparedStatement pst = null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url);
			pst = con.prepareStatement(qry);
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setDouble(3, sal);
			pst.execute();
		
		} catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
		
		
	}
	

}

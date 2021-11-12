package com.varun.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentRegistration extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		System.out.println("I am doPost method");
		System.out.println("request object "+req);
		String studentName=req.getParameter("studentName");
		String studentId=req.getParameter("studentId");
		String studentLocation=req.getParameter("studentLocation");
		System.out.println("StudentName = "+studentName);
		System.out.println("StudentId = "+studentId);
		System.out.println("StudentLocation = "+studentLocation);
		//jdbc 
		//connection create
		//We need a table in database
		//we shoulde write insert query to insert user into database table
		
			try {
				System.out.println("loading....");
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("driver loaded ");
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsdb", "root", "root");
				Statement statement=connection.createStatement();
				String sql="insert into students values('"+studentName+"',"+studentId+",'"+studentLocation+"')";
				System.out.println("sql = "+sql);
				int count=statement.executeUpdate(sql);
				System.out.println("count "+count);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				PrintWriter out=resp.getWriter();
				out.println("<p>Successfully User Created</p>");
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

}

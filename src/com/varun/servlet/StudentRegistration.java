package com.varun.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentRegistration extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("I am doPost method");
		System.out.println("request object "+req);
		String studentName=req.getParameter("studentName");
		System.out.println("StudentName = "+studentName);
		System.out.println("done");
	}

}

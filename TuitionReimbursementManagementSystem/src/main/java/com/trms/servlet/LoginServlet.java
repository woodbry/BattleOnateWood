package com.trms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trms.beans.Employee;
import com.trms.daoimpl.EmployeesDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doPost");
		Employee emp = null;
		ObjectMapper mapper= new ObjectMapper();
		EmployeesDaoImpl empdi = new EmployeesDaoImpl();
		//convert JSON to POJO
		//YOU NEED A DEFAULT CONSTRUCTOR  IN YOUR JAVA OBJECT CLASS IN ORDER TO DO THIS
		emp = mapper.readValue(request.getInputStream(), Employee.class);
		System.out.println(emp);
		emp = empdi.login(emp.getUserName(),emp.getPassword());
		PrintWriter pw = response.getWriter();
		pw.write("<h3>Welcome "+ emp.getFirstName()+" "+emp.getLastName()+"</h3>");
		pw.close();
		
	}

}

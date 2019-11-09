package com.trms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trms.beans.Employee;
import com.trms.daoimpl.EmployeesDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doPost");
		Employee emp = null;
		ObjectMapper mapper= new ObjectMapper();
		EmployeesDaoImpl empdi = new EmployeesDaoImpl();
		
		//convert JSON to POJO
		//YOU NEED A DEFAULT CONSTRUCTOR  IN YOUR JAVA OBJECT CLASS IN ORDER TO DO THIS
		emp = mapper.readValue(request.getInputStream(), Employee.class);
//		System.out.println("Am I still null?" + emp);
		
		emp = empdi.login(emp.getUserName(),emp.getPassword());
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession(true);
		if(emp.getFirstName() != null) {
//			HttpSession session = request.getSession(true);
			session.setAttribute("employee_id", emp.getEmpId());
			session.setAttribute("name", emp.getFirstName()+" "+emp.getLastName());
			pw.write("Welcome " +session.getAttribute("name"));
			response.sendRedirect("mainpage");
		}else {
			pw.print("Sorry, invalid username/password combination!");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		
		pw.close();
		
	}

}

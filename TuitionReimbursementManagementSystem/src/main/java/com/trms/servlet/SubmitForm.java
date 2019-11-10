package com.trms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trms.beans.Forms;
import com.trms.daoimpl.FormsDaoImpl;

/**
 * Servlet implementation class SubmitForm
 */
public class SubmitForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("DummyFormGetter.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doPost");
		Forms f=null;
		ObjectMapper mapper= new ObjectMapper();
		//convert JSON to a Java Object
		//YOU NEED A DEFAULT CONSTRUCTOR IN UR JAVA OBJECT CLASS IN ORDER TO USE THIS!!
		f=mapper.readValue(request.getInputStream(), Forms.class);
		System.out.println(f);
		FormsDaoImpl fdi= new FormsDaoImpl();
		try {
			fdi.addForm(f);
			PrintWriter pw=response.getWriter();
			pw.write("<h3>Added Form Game</h3>");
			pw.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

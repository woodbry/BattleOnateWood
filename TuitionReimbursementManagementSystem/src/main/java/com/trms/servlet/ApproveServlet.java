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
 * Servlet implementation class ApproveServlet
 */
public class ApproveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doGet");
		ObjectMapper mapper= new ObjectMapper();
		FormsDaoImpl fdi = new FormsDaoImpl();
		int id = mapper.readValue(request.getParameter("fid"), Integer.class);
		PrintWriter out =response.getWriter();
		String fJSON;
		
		try {
			fJSON=mapper.writeValueAsString(fdi.getFormByFId(id));
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			System.out.println("did ya get that thing i sent ya? :" +id);
			out.print(fJSON);
			System.out.println(fJSON);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}out.flush();
	}
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//APPROVAL POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doPost");
		Forms f=null;
		ObjectMapper mapper= new ObjectMapper();
		FormsDaoImpl fdi= new FormsDaoImpl();
		int id = mapper.readValue(request.getParameter("aid"), Integer.class);
		//convert JSON to a Java Object
		//YOU NEED A DEFAULT CONSTRUCTOR IN UR JAVA OBJECT CLASS IN ORDER TO USE THIS!!
		try {
			f= fdi.getFormByFId(id);
			System.out.println(f);
			fdi.updateFormSA(f);
			PrintWriter pw=response.getWriter();
			pw.write("<h3>Added Form</h3>");
			pw.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

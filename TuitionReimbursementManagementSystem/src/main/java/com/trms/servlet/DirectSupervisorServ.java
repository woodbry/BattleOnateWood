package com.trms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trms.daoimpl.FormsDaoImpl;

/**
 * Servlet implementation class DirectSupervisorServ
 */
public class DirectSupervisorServ extends HttpServlet {
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
			System.out.println("in doGet that returns all forms to supervisor by name");
			ObjectMapper mapper= new ObjectMapper();
			FormsDaoImpl fdi = new FormsDaoImpl();
			//int id = mapper.readValue(request.getParameter("fid"), Integer.class);
			PrintWriter out =response.getWriter();
			String fJSON;
			fJSON=mapper.writeValueAsString(fdi.getFormBySupervisor("Dorothy Diaz"));
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			System.out.println("did ya get that thing i sent ya? ");
			out.print(fJSON);
			System.out.println(fJSON);out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.trms.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trms.beans.Forms;
import com.trms.dao.FormsDao;
import com.trms.util.Connect;

public class FormsDaoImpl implements FormsDao {
	public static Connect conn = Connect.getInstance();
//	@Override
	public List<Forms> getAllForms() throws SQLException {
		ArrayList<Forms> empList = new ArrayList<Forms>();
		Connection c= conn.getConnection();
		java.sql.Statement stmt;
		try {
		stmt= c.createStatement();
		ResultSet rs = stmt.executeQuery("select * from form");
		Forms p = null;
		while(rs.next()) {
			p =new Forms(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6));
			empList.add(p);
		}return empList;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

//	@Override
	public Forms getFormByFId(int formId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
	public List<Forms> getFormByEId(int empId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Forms> getFormBySupervisor(String name){
		//not sure if the string is needed or if I can just pull down session token from here
		
		return null;
	}
//	@Override
	public void addForm(Forms f) throws SQLException {
		// TODO Auto-generated method stub
		
	}

//	@Override
	public void updateForm(Forms f) throws SQLException {
		// TODO Auto-generated method stub
		
	}

//	@Override
	public void removeForm(Forms f) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
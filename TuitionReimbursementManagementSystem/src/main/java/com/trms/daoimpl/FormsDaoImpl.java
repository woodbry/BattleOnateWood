package com.trms.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
			p =new Forms(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getString(4),rs.getString(5), 
					 rs.getDouble(6), rs.getBoolean(7), rs.getBoolean(8),rs.getBoolean(9),rs.getString(10));
			empList.add(p);
		}return empList;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

//	@Override
	public Forms getFormByFId(int formId) throws SQLException {
	 Forms f = null;
	 Connection c = conn.getConnection();
	 String sql = "select * from forms where form_id= ?";
	 PreparedStatement ps = c.prepareStatement(sql);
	 ps.setInt(1, formId);
	 ResultSet rs = ps.executeQuery();
	 while(rs.next()) {
		 f= new Forms(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getString(4),rs.getString(5), 
				 rs.getDouble(6), rs.getBoolean(7), rs.getBoolean(8),rs.getBoolean(9),rs.getString(10));
	 }
	 return f;
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
		Connection c = conn.getConnection();
		String sql = "insert into forms values(default,?,?,?,?,?,default,default,default,?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1,f.getEmpId());
		ps.setString(2, f.getSupervisorName());
		ps.setString(3, f.getEventName());
		ps.setString(4, f.getEventType());
		ps.setDouble(5, f.getEventCost());
		ps.setString(6, f.getDateCompleted());
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
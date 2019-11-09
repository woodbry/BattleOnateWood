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
		ResultSet rs = stmt.executeQuery("select * from forms");
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
	//FOR EMPLOYEE DASHBOARD
	public List<Forms> getFormByEId(int empId) throws SQLException {
			ArrayList<Forms> formsList = new ArrayList<Forms>();
			Connection c= conn.getConnection();
			java.sql.Statement stmt;
			try {
				PreparedStatement ps = c.prepareStatement("select * from forms where submittor_eid=?");
				ps.setInt(1, empId);
				ResultSet rs = ps.executeQuery();
				Forms p = null;
			while(rs.next()) {
				p =new Forms(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getString(4),rs.getString(5), 
						 rs.getDouble(6), rs.getBoolean(7), rs.getBoolean(8),rs.getBoolean(9),rs.getString(10));
				formsList.add(p);
			}return formsList;
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			return null;
	}
	//FOR EMPLOYEE DASHBOARD
		public List<Forms> getFormsForDH() throws SQLException {
				ArrayList<Forms> formsList = new ArrayList<Forms>();
				Connection c= conn.getConnection();
				java.sql.Statement stmt;
				try {
					PreparedStatement ps = c.prepareStatement("select * from forms where supervisor_approval=true");
					ResultSet rs = ps.executeQuery();
					Forms p = null;
				while(rs.next()) {
					p =new Forms(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getString(4),rs.getString(5), 
							 rs.getDouble(6), rs.getBoolean(7), rs.getBoolean(8),rs.getBoolean(9),rs.getString(10));
					formsList.add(p);
				}return formsList;
				} catch(SQLException e) {
					e.printStackTrace();
				}
				
				return null;
		}
		//FOR EMPLOYEE DASHBOARD
		public List<Forms> getFormsForBC() throws SQLException {
				ArrayList<Forms> formsList = new ArrayList<Forms>();
				Connection c= conn.getConnection();
				//java.sql.Statement stmt;
				try {
					PreparedStatement ps = c.prepareStatement("select * from forms where supervisor_approval= true and dep_head_approval=true");
//					ps.setInt(1, empId);
					ResultSet rs = ps.executeQuery();
					Forms p = null;
				while(rs.next()) {
					p =new Forms(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getString(4),rs.getString(5), 
							 rs.getDouble(6), rs.getBoolean(7), rs.getBoolean(8),rs.getBoolean(9),rs.getString(10));
					formsList.add(p);
				}return formsList;
				} catch(SQLException e) {
					e.printStackTrace();
				}
				
				return null;
		}
	//FOR SUPERVISOR DASHBOARD
	public List<Forms> getFormBySupervisor(String name){
		ArrayList<Forms> formsList = new ArrayList<Forms>();
		Connection c= conn.getConnection();
		
		try {
			PreparedStatement ps = c.prepareStatement("select * from forms where supervisor_name=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			Forms p = null;
		while(rs.next()) {
			p =new Forms(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getString(4),rs.getString(5), 
					 rs.getDouble(6), rs.getBoolean(7), rs.getBoolean(8),rs.getBoolean(9),rs.getString(10));
			formsList.add(p);
		}return formsList;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
//	@Override
	public void addForm(Forms f) throws SQLException {
		// TODO Auto-generated method stub
		Connection c = conn.getConnection();
		String sql = "insert into forms values(default,?,?,?,?,?,default,default,default,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1,f.getEmpId());
		ps.setString(2, f.getSupervisorName());
		ps.setString(3, f.getEventName());
		ps.setString(4, f.getEventType());
		ps.setInt(5, (int) f.getEventCost());
		ps.setString(6, f.getDateCompleted());
		ps.executeUpdate();
		System.out.println("Form added");
	}
// APPROVAL UPDATE FOR SUPERVISOR
	public void updateFormSA(Forms f) throws SQLException {
		Connection c = conn.getConnection();
		String sql = "update forms set super_approval= true where form_id =?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, f.getFormId());
		ps.execute();
		ps = c.prepareStatement("commit");
		ps.execute();		
	}
	
	// APPROVAL UPDATE FOR DEPARTMENT HEAD
		public void updateFormDHA(Forms f) throws SQLException {
			Connection c = conn.getConnection();
			String sql = "update forms set dep_head_approval= true where form_id =?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, f.getFormId());
			ps.execute();
			ps = c.prepareStatement("commit");
			ps.execute();		
		}
		// APPROVAL UPDATE FOR BENEFITS COORDINATOR
				public void updateFormBCA(Forms f) throws SQLException {
					Connection c = conn.getConnection();
					String sql = "update forms set ben_coord_approval= true where form_id =?";
					PreparedStatement ps = c.prepareStatement(sql);
					ps.setInt(1, f.getFormId());
					ps.execute();
					ps = c.prepareStatement("commit");
					ps.execute();		
				}

//	@Override
	public void removeForm(Forms f) throws SQLException {
		// TODO Auto-generated method stub 
		
	}

	@Override
	public void updateForm(Forms f) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
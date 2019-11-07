package com.trms.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trms.beans.Employee;
import com.trms.dao.EmployeeDao;
import com.trms.util.Connect;

public class EmployeesDaoImpl implements EmployeeDao {
	public static Connect conn = Connect.getInstance();
	
//	@Override
	public List<Employee> getAllEmployees() throws SQLException {
		ArrayList<Employee> empList = new ArrayList<Employee>();
		Connection c= conn.getConnection();
		Statement stmt;
		try {
		stmt= c.createStatement();
		ResultSet rs = stmt.executeQuery("select * from employee");
		Employee p = null;
		while(rs.next()) {
			p =new Employee(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4),rs.getInt(5),rs.getString(6));
			
			empList.add(p);
		}return empList;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return empList;
	}
	public Employee login(String name, String secret) {
		Employee emp = null;
		Connection c = conn.getConnection();
		String sql = "select * from employee_login(?,?)";
		ResultSet rs;
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, secret);
			rs = ps.executeQuery();
			while (rs.next()) {
			emp = new Employee();
			emp.setEmpId(rs.getInt(1));
			emp.setFirstName(rs.getString(2));
			emp.setLastName(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emp;
	}
//	@Override
	public Employee getEmployeeByFId(int formId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
	public Employee getEmployeeByEId(int empId) throws SQLException {
		Connection c= conn.getConnection();
		String sql = "select * from employee where employee_id = ?";
		try {
		PreparedStatement ps= c.prepareStatement(sql);
		ps.setInt(1, empId);
		ResultSet rs = ps.executeQuery();
		Employee e = null;
		while(rs.next()) {
			e=new Employee(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4),rs.getInt(5),rs.getString(6));
		}
		return e;
		}catch(SQLException e) {e.printStackTrace();}
		return null;
	}

//	@Override
	public void addEmployee(Employee e) throws SQLException {
		Connection c = conn.getConnection();
		String sql = "insert into employee values(default,?,?,?,?) ";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1,e.getFirstName()+":"+e.getLastName());
		ps.setString(2,  e.getUserName());
		ps.setDouble(3, e.getAvailableFunds());
		ps.setString(3,e.getLocation());
	}

//	@Override
	public void updateEmployee(Employee e) throws SQLException {
		 Connection c = conn.getConnection();
		 String str = "update from employee set available_funds =? where employee_id = ?";
		 try {
			 PreparedStatement ps = c.prepareStatement(str);
			 ps.setInt(2, e.getEmpId());
			 ps.setDouble(1, e.getAvailableFunds());
			 ps.execute();
			 ps = c.prepareStatement("commit");
			 ps.executeUpdate();
		 }catch(SQLException es) {
			 es.printStackTrace();
		 }
		
	}


//	@Override
	public void removeEmployee(Employee e) throws SQLException {
		 Connection c = conn.getConnection();
		 String str = "delete from employee where employee_id = ?";
		 try {
			 PreparedStatement ps = c.prepareStatement(str);
			 ps.setInt(1, e.getEmpId());
			 ps.execute();
			 ps= c.prepareStatement("commit");
			 ps.execute();
		 }catch(SQLException es) {
			 es.printStackTrace();
		 }
		
	}


}
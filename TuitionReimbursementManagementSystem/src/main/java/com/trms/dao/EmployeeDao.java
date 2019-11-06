package com.trms.dao;

import java.sql.SQLException;
import java.util.List;

import com.trms.beans.Employee;

public interface EmployeeDao {
public List<Employee> getAllEmployees() throws SQLException;

	public Employee getEmployeeByFId(int formId) throws SQLException;

	public Employee getEmployeeByEId(int empId) throws SQLException;

	public void addForm(Employee e) throws SQLException;

	public void updateForm(Employee e) throws SQLException;

	public void removeForm(Employee e) throws SQLException;
}
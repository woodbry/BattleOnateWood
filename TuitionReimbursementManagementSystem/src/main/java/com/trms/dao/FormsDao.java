package com.trms.dao;

import java.sql.SQLException;
import java.util.List;

import com.trms.beans.Forms;

public interface FormsDao {

	public List<Forms> getAllForms() throws SQLException;

	public Forms getFormByFId(int formId) throws SQLException;

	public List<Forms> getFormByEId(int empId) throws SQLException;

	public void addForm(Forms f) throws SQLException;

	public void updateForm(Forms f) throws SQLException;

	public void removeForm(Forms f) throws SQLException;
}
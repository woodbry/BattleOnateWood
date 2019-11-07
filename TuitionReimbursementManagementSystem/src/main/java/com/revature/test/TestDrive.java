package com.revature.test;

import java.sql.SQLException;

import com.trms.daoimpl.EmployeesDaoImpl;
import com.trms.daoimpl.FormsDaoImpl;

public class TestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FormsDaoImpl fdi = new FormsDaoImpl();
		EmployeesDaoImpl edi = new EmployeesDaoImpl();
		//System.out.println("can you hear me now??");
		System.out.println(edi.login("bbarker", "1"));
	try {
		System.out.println(edi.getEmployeeByEId(10101084));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}

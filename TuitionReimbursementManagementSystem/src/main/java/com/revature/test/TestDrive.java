package com.revature.test;

import com.trms.daoimpl.EmployeesDaoImpl;
import com.trms.daoimpl.FormsDaoImpl;

public class TestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FormsDaoImpl fdi = new FormsDaoImpl();
		EmployeesDaoImpl edi = new EmployeesDaoImpl();
		//System.out.println("can you hear me now??");
		System.out.println(edi.login("bbarker", "1"));
		
	}

}

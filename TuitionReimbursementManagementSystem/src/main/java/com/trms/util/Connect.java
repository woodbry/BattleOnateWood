package com.trms.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//import com.revature.util.ConnFac;

public class Connect {
	private static Connect cf= new Connect();
	//private no args constructor
	private Connect() {
		super();
	}
	//public static synchronized getter method
	public static synchronized Connect getInstance() {
		if(cf == null) {
			cf = new Connect();
		}
		return cf;
	}
	
	//methods that 'do the things'
	public Connection getConnection() {
		java.sql.Connection conn = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			conn= DriverManager.getConnection("jdbc:postgresql://mypegabatch.cfgmuw0zkwrh.us-east-2.rds.amazonaws.com/postgres",
					"MadScientist626", "3eDru-=0FaP8L-tiTh8p");

		} catch (SQLException e) {
			System.out.println("Failed to create connection");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}

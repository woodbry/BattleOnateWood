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
		Properties prop = new Properties();
		try {
		String	url="jdbc:postgresql://battlem2072.c8h37embw41w.us-east-2.rds.amazonaws.com/postgres";
			String	user="mariobattle";
			String	password="1qaz2wsx3edc";
//			prop.load(new FileReader("database.properties"));
//			conn= DriverManager.getConnection(prop.getProperty("url"),
//					prop.getProperty("user"), prop.getProperty("password"));
			conn= DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			System.out.println("Failed to create connection");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}

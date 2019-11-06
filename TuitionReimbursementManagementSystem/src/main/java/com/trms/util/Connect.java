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
			prop.load(new FileReader("src/main/resources/database.properties"));
			conn= DriverManager.getConnection(prop.getProperty("url"),
					prop.getProperty("user"), prop.getProperty("password"));
//			conn= DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			System.out.println("Failed to create connection");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}

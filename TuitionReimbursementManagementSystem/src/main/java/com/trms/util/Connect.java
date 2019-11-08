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
<<<<<<< HEAD
			Class.forName("org.postgresql.Driver");
			conn= DriverManager.getConnection("jdbc:postgresql://mypegabatch.cfgmuw0zkwrh.us-east-2.rds.amazonaws.com/postgres",
					"MadScientist626", "3eDru-=0FaP8L-tiTh8p");

=======
		String	url="jdbc:postgresql://battlem2072.c8h37embw41w.us-east-2.rds.amazonaws.com/postgres";
			String	user="mariobattle";
			String	password="1qaz2wsx3edc";
//			prop.load(new FileReader("database.properties"));
//			conn= DriverManager.getConnection(prop.getProperty("url"),
//					prop.getProperty("user"), prop.getProperty("password"));
			conn= DriverManager.getConnection(url,user,password);
>>>>>>> 0463ab7bddfc420b95fffa765c71e56786a14b50
		} catch (SQLException e) {
			System.out.println("Failed to create connection");
			// TODO Auto-generated catch block
			e.printStackTrace();
<<<<<<< HEAD
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
=======
>>>>>>> 0463ab7bddfc420b95fffa765c71e56786a14b50
		}
		return conn;
	}
}

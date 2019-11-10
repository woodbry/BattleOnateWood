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



			try {

				Class.forName("org.postgresql.Driver");

			} catch (ClassNotFoundException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

			conn= DriverManager.getConnection("jdbc:postgresql://grantdb22.cvy92ehtyzzn.us-east-2.rds.amazonaws.com/postgres",

					"grantDB22", "Grant092291.");

//
//			String url = "jdbc:postgresql://grantdb22.cvy92ehtyzzn.us-east-2.rds.amazonaws.com/postgres";
//			String username = "grantDB22";
//			String password = "Grant092291.";


		} catch (SQLException e) {

			System.out.println("Failed to create connection");

			// TODO Auto-generated catch block

			e.printStackTrace();



		}

		return conn;

	}

}
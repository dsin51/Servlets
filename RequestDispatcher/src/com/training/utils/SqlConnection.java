package com.training.utils;

import java.io.*;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;


public class SqlConnection {

	  
	public static Connection getOracleConnection() {
		Connection con = null;
		try {
			Properties prop = new Properties();
			
			FileInputStream inStream = new FileInputStream(new File("DBConnection.properties"));
			prop.load(inStream);
			
			Class.forName(prop.getProperty("db.className"));
			
			con = DriverManager.getConnection(
								prop.getProperty("db.url"),
								prop.getProperty("db.userName"),
								prop.getProperty("db.passWord")
							);
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return con;
	}
	
	
	public static Connection getOracleConnection(InputStream inStream) {
		Connection con = null;
		try {
			Properties prop = new Properties();
			
			prop.load(inStream);
			
			Class.forName(prop.getProperty("db.className"));
			
			con = DriverManager.getConnection(
								prop.getProperty("db.url"),
								prop.getProperty("db.userName"),
								prop.getProperty("db.passWord")
							);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Connection *******************"+con);
		return con;
	}
}

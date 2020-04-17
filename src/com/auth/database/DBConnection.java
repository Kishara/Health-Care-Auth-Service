package com.auth.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	
	
public static Connection connect() {
		
	
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/authservice", "root", "root");
			System.out.println("Database Connected");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	
}
	
}

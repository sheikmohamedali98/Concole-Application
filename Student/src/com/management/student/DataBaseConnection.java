package com.management.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DataBaseConnection {
	Connection con;
	DataBaseConnection(){
		try {
			con = DriverManager.getConnection(Server.URL,Server.USERNAME,Server.PASSWORD);
			System.out.println("Connection Created ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void close() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

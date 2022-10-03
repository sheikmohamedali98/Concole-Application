package com.hotelmanagement.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.hotelmanagement.server.Server;

public class DataBaseConnection {

	static  Connection con;

	DataBaseConnection() {
		try {
			con = DriverManager.getConnection(Server.URL, Server.USERNAME, Server.PASSWORD);
			System.out.println("Connection Created ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sorry");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DataBaseConnection connect = new DataBaseConnection();
	}

	static void close() {

		try {
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

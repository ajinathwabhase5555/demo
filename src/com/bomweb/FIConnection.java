//This class is for connecting to database.
package com.bomweb;

import java.sql.Connection;
import java.sql.DriverManager;

public class FIConnection {

	 static String driver = "com.mysql.jdbc.Driver";
	 static String url = "jdbc:mysql://localhost:3306/sonoo";
	 static String user = "root";
//	 static String user = "bom";
	 static String password = "root";
	// String database_name = "CBI FIServer";
	

	public static Connection getConnection() throws Exception {
		try {
			Connection connection = null;
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			return connection;
			
		} catch (Exception ex) {
			throw new Exception("Error while opening SQL connection: "
					+ ex.toString());
		}
	}
}

package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	public class GetConnection{
		public static Connection getConnection() {
			String url = "jdbc:mysql://localhost/";
			String dbName = "cda_21157_final_prenom";
			String user  = "root";
			String pwd = "";
			
			Connection connect = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				try {
					connect=DriverManager.getConnection(url+dbName,user,pwd);
					System.out.println("OK for connect");
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return connect;
		}
	}
}

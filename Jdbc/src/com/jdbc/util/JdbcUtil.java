package com.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	public static Connection getMySqlConnection() {
		Connection con = null;
		try {
			// Step 1:Load the Driver class.
			Class.forName("com.mysql.jdbc.Driver");
			// Step 2: Establish the connection.
			final String url = "jdbc:mysql://localhost:3307/testdb";
			con = DriverManager.getConnection(url, "root", "sh@il");
		} catch (ClassNotFoundException | SQLException e) {

		}
		return con;
	}

	public static void closeResource(Connection con, Statement st) {
		try {
			if (con != null) {
				con.close();
			}
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {

		}
	}
}

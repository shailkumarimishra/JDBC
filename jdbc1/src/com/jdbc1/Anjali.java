package com.jdbc1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Anjali implements Runnable {

	@Override
	public void run() {
		System.out.println("Anjali thread started");
		Connection con = null;
		PreparedStatement ps1 = null;

		try {
			
			con = JDBC1Util.getConnection();
			System.out.println("anjali connnection"+" "+con);
			
//			operation2
			String sql1 = "update student set stuname=? where stuid=?";
			ps1 = con.prepareStatement(sql1);
			ps1.setString(1, "shradha123");
			ps1.setInt(2, 101);
			Thread.sleep(7000);
			ps1.executeUpdate();

			System.out.println("Anjali thread finished");

		} catch (Exception e) {
			if (con != null) {
				try {
					con.rollback();// Transaction finished
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		} 
	}

}

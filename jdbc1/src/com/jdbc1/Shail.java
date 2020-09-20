package com.jdbc1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Shail implements Runnable {

	@Override
	public void run() {
		System.out.println("shail thread started");
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = JDBC1Util.getConnection();
			System.out.println("shail connnection"+" "+con);
			con.setAutoCommit(false);// Transaction started
			con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			System.out.println("shail thread aquired lock");
			String sql = "select * from student where stuid=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, 101);
			Thread.sleep(8000);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
			}
			
			con.commit();// Transaction finished
			System.out.println("shail thread finished");

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

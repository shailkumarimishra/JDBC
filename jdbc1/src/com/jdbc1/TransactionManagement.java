package com.jdbc1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionManagement {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		
		try {
			 con = JDBC1Util.getConnection();
		
			con.setAutoCommit(false);// Transaction started
			String sql = "select * from student";
			 ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
			}
			System.out.println(10/0);
//			operation2
			String sql1="update student set stuname=? where stuid=?";
			ps1 = con.prepareStatement(sql1);
			ps1.setString(1,"shaily");
			ps1.setInt(2,101);
			ps1.executeUpdate();
			
			
			con.commit();//Transaction finished

		} catch (Exception e) {
			if(con!=null) {
				try {
					con.rollback();//Transaction finished
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		}finally {
			JDBC1Util.closeResource(con, ps);
		}
	}
}

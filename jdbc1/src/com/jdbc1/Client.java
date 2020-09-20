package com.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Client {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		try {
			 con =JDBC1Util.getConnection();
//		 String sql="delete from student where stuid=112";
			 String sql="update student set stuname='Ambe' where stuid=102";
		  st = con.createStatement();
		 int i = st.executeUpdate(sql);
		 if(i==1) {
//			 System.out.println("Record deleted...");
			 System.out.println("Record updated successfully...");
		 }
		 else {
			 System.out.println("Record not found!!");
		 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC1Util.closeResource(con, st);	
			}
	}

}

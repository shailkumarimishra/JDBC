package com.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC1Demo {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		try {
			//step1:- load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		 //step2:- get the connection
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3307/testdb","root","sh@il");
		//step3:- prepare sql statement
		String sql="insert into student values(222,'shail@gmail.com','Shailza',221232)";
		//step4:- prepare jdbc statement
		 st = con.createStatement();
		//step5:- submit sql query to database using jdbc statement
//		 int x = st.executeUpdate(sql);
		 st.executeQuery(sql);
		 System.out.println("done");
		//step6:- process the result
			/*
			 * if(x==1) { System.out.println("Record inserted successfully..."); } else {
			 * System.out.println("Record not inserted!!"); }
			 */
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			//step7:- close all resources
			
				try {
					if(con!=null) {
					con.close();
					}
					if(st!=null) {
						st.close();
					}
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}



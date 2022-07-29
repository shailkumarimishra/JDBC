package com.jdbc.jar.test;

import java.sql.Connection;
import java.sql.Statement;

import com.jdbc1.jartemplate.JDBCUtil;

public class JDBCJarTest {

	public static void main(String[] args) {
		try(Connection con = JDBCUtil.getConnection()){
			Statement st = con.createStatement();
			String sql="insert into student values(333,'shaily@gmail.com','Shaily',5423232)";
			int result = st.executeUpdate(sql);
			if (result == 1) {
				System.out.println("record inserted successfully...");
			} else {
				System.out.println("record not inserted!!");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

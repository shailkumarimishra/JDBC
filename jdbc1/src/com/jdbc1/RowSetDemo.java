package com.jdbc1;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class RowSetDemo {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			RowSetFactory rsf = RowSetProvider.newFactory();
//			RowSet rs = rsf.createJdbcRowSet();
			RowSet rs = rsf.createCachedRowSet();
			rs.setUrl("jdbc:mysql://localhost:3307/testdb");
			rs.setUsername("root");
			rs.setPassword("sh@il");
			rs.setCommand("select * from student");
			rs.execute();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

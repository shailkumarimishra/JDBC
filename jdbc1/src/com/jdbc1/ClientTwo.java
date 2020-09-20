package com.jdbc1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientTwo {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		try {
			 con = JDBC1Util.getConnection();
//			 DatabaseMetaData metaData = con.getMetaData();
//			 System.out.println(metaData.getDefaultTransactionIsolation());
//			 System.out.println(con.getAutoCommit());
		    String sql="select * from student";
		     st = con.createStatement();
		    ResultSet rs = st.executeQuery(sql);
		    if(rs.next()) {
		    	do {
		    		System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getInt(3)+","+rs.getString(4));
		    	}while(rs.next());
		    }
		}
		catch(SQLException e) {
			
		}
		finally {
		   JDBC1Util.closeResource(con, st);
		}
	}

}

package com.jdbc1;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBC1Template {
	private static final String CLOSING_BRASES = ")";
	private static final String OPENING_BRASES = "(";
	private static final String SINGLE_QUOTE = "'";
	private static final String COMMA = ",";

	public void save(Student stu) {
//		Statement st = null;
		try(Connection con=JDBC1Util.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?)");) {
			
//		 String sql="insert into student values"+OPENING_BRASES+stu.getStuID()+COMMA+SINGLE_QUOTE+stu.getStuName()+SINGLE_QUOTE+COMMA+stu.getStuPhone()+COMMA+SINGLE_QUOTE+stu.getStuEmail()+SINGLE_QUOTE+CLOSING_BRASES;
//		 String sql = String.format("insert into student values(%d,'%s',%d,'%s')",stu.getStuID(),stu.getStuName(),stu.getStuPhone(),stu.getStuEmail()); 
//		 System.out.println(sql);
//		 st = con.createStatement();
			
			ps.setInt(1, stu.getStuID());
			ps.setString(2, stu.getStuName());
			ps.setInt(3, stu.getStuPhone());
			ps.setString(4, stu.getStuEmail());
//		  int a = st.executeUpdate(sql);
			int a = ps.executeUpdate();
			if (a == 1) {
				System.out.println("record inserted successfully...");
			} else {
				System.out.println("record not inserted!!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}/* finally {
			JDBC1Util.closeResource(con, st);
		}*/
	}

	public void delete(int stuId) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JDBC1Util.getConnection();
			ps = con.prepareStatement("delete from student where stuid=?");
			ps.setInt(1, stuId);
			int i = ps.executeUpdate();
			if (i == 1) {
				System.out.println("Record deleted...");
			} else {
				System.out.println("Record not found!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC1Util.closeResource(con, ps);
		}
	}

	public void update(int stuId,String stuName) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JDBC1Util.getConnection();
			ps = con.prepareStatement("update student set stuname=? where stuid=?");
			ps.setString(1,stuName);
			ps.setInt(2, stuId);
			int a = ps.executeUpdate();
			if (a == 1) {
				System.out.println("Record updated successfully...");
			} else {
				System.out.println("Record not found!!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC1Util.closeResource(con, ps);
		}

	}
	public List<Student> findAll(){
		Connection con=null;
		PreparedStatement ps=null;
		List<Student> allRecord=new ArrayList<>();
		  
		try {
			 con = JDBC1Util.getConnection();
			  ps = con.prepareStatement("select * from student");
			  ResultSet rs = ps.executeQuery();
			  while(rs.next()) {
				  
				  Student stu=new Student();
					  int sid = rs.getInt(1);
					  String name = rs.getString(2);
					  int phone = rs.getInt(3);
					  String email = rs.getString(4);
					  stu.setStuID(sid);
					  stu.setStuName(name);
					  stu.setStuPhone(phone);
					  stu.setStuEmail(email);
//					  System.out.println(stu);
					  allRecord.add(stu);
				  }
			  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC1Util.closeResource(con, ps);
		}
		return allRecord;
	}

	public Student findBySId(int stuId) {
		Connection con=null;
		PreparedStatement ps=null;
		Student stu=new Student();
		try {
			 con = JDBC1Util.getConnection();
			  ps = con.prepareStatement("select * from student where stuid=?");
			  ps.setInt(1,stuId);
			  ResultSet rs = ps.executeQuery();
			  if(rs.next()) {
			  int sid = rs.getInt(1);
			  String name = rs.getString(2);
			  int phone = rs.getInt(3);
			  String email = rs.getString(4);
			  stu.setStuID(sid);
			  stu.setStuName(name);
			  stu.setStuPhone(phone);
			  stu.setStuEmail(email);
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC1Util.closeResource(con, ps);
		}
		return stu;
	}
}

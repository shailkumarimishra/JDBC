package com.jdbc.entity;

public class StudentEntity {
	private int studentId;
	private String studentName;
	private int StudentPhone;
	private String studentEmail;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentPhone() {
		return StudentPhone;
	}
	public void setStudentPhone(int studentPhone) {
		StudentPhone = studentPhone;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	
}

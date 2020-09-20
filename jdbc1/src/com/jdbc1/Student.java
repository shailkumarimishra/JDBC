package com.jdbc1;

public class Student {
private int stuId;
private String stuName;
private int stuPhone;
private String stuEmail;
public Student() {
	super();
}
public Student(int stuID, String stuName, int stuPhone, String stuEmail) {
	super();
	this.stuId = stuID;
	this.stuName = stuName;
	this.stuPhone = stuPhone;
	this.stuEmail = stuEmail;
}
public int getStuID() {
	return stuId;
}
public void setStuID(int stuID) {
	this.stuId = stuID;
}
public String getStuName() {
	return stuName;
}
public void setStuName(String stuName) {
	this.stuName = stuName;
}
public int getStuPhone() {
	return stuPhone;
}
public void setStuPhone(int stuPhone) {
	this.stuPhone = stuPhone;
}
public String getStuEmail() {
	return stuEmail;
}
public void setStuEmail(String stuEmail) {
	this.stuEmail = stuEmail;
}


@Override
public String toString() {
	return "Student [stuID=" + stuId + ", stuName=" + stuName + ", stuPhone=" + stuPhone + ", stuEmail=" + stuEmail
			+ "]";
}


}

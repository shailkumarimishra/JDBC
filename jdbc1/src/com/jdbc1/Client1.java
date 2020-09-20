package com.jdbc1;

import java.util.List;
import java.util.Scanner;

public class Client1 {

	public static void main(String[] args) {
//		Student stu=new Student(118,"sumit", 48433, "sumit@gmail.com");
//		Student stu=new Student();
		JDBC1Template temp=new JDBC1Template();
//		temp.save(stu);
//		temp.delete(117);
//		temp.update(116,"tanya");
//		List<Student> findAll = temp.findAll();
//		findAll.forEach(System.out::println);
//		System.out.println(temp.findBySId(115));
		Scanner sc=new Scanner(System.in);
		System.out.println("please enter sid,name,phone,email");
		int sid = sc.nextInt();
		String name = sc.next();
		int phone = sc.nextInt();
		String email = sc.next();
		Student stu=new Student(sid, name, phone, email);
		temp.save(stu);
	}

}

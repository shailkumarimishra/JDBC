package com.jdbc.client;

import java.util.List;

import com.jdbc.model.Student;
import com.jdbc.service.StudentService;
import com.jdbc.service.impl.StudentServiceImpl;

public class Client {

	public static void main(String[] args) {
		StudentService service=new StudentServiceImpl();
		List<Student> list = service.getAllStudent();
		list.forEach(s->System.out.println(s.getStudentId()+" "+s.getStudentName()+" "+s.getStudentPhone()+" "+s.getStudentEmail()));

	}

}

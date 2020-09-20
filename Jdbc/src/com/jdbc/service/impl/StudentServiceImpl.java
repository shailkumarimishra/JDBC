package com.jdbc.service.impl;

import java.util.List;

import com.jdbc.dao.StudentDAO;
import com.jdbc.dao.impl.StudentDAOImpl;
import com.jdbc.entity.StudentEntity;
import com.jdbc.mapper.StudentMapper;
import com.jdbc.mapper.StudentMapperImpl;
import com.jdbc.model.Student;
import com.jdbc.service.StudentService;

public class StudentServiceImpl implements StudentService {

	@Override
	public List<Student> getAllStudent() {
		StudentDAO dao=new StudentDAOImpl(); 
		List<StudentEntity> list = dao.findAll();
		System.out.println(list+"  anu");
		StudentMapper mapper=new StudentMapperImpl();
		return mapper.mapToStudent(list);
	}

	@Override
	public Student getOneStudent(int studentId) {
		StudentDAO dao=new StudentDAOImpl();
		List<StudentEntity> list=null;
//		list.add(dao.findOneStudent());
		StudentMapper mapper=new StudentMapperImpl();
		return mapper.mapToStudent(list.add(dao.findOneStudent())) ;
	}

	@Override
	public String updateStudent(Student stu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteStudent(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

}

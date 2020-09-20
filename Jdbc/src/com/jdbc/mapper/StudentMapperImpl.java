package com.jdbc.mapper;

import java.util.ArrayList;
import java.util.List;

import com.jdbc.entity.StudentEntity;
import com.jdbc.model.Student;

public class StudentMapperImpl implements StudentMapper {

	@Override
	public List<Student> mapToStudent(List<StudentEntity> entities) {
		List<Student>list=new ArrayList<>();
		for(StudentEntity entity:entities) {
			Student stu=new Student();
			stu.setStudentId(entity.getStudentId());
			stu.setStudentName(entity.getStudentName());
			stu.setStudentPhone(entity.getStudentPhone());
			stu.setStudentEmail(entity.getStudentEmail());
			list.add(stu);
		}
		System.out.println(list+"  kalawati");
		return list;
	}

	@Override
	public List<StudentEntity> mapToStudentEntity(List<Student> students) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentEntity mapToStudentEntity(Student stu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student mapToStudent(StudentEntity entity) {
		Student stu=new Student();
		stu.setStudentId(entity.getStudentId());
		stu.setStudentName(entity.getStudentName());
		stu.setStudentPhone(entity.getStudentPhone());
		stu.setStudentEmail(entity.getStudentEmail());

		return stu;
	}

}

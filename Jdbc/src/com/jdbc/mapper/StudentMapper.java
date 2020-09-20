package com.jdbc.mapper;

import java.util.List;

import com.jdbc.entity.StudentEntity;
import com.jdbc.model.Student;

public interface StudentMapper {
public List<Student> mapToStudent(List<StudentEntity> entities);
public List<StudentEntity> mapToStudentEntity(List<Student> students);
public StudentEntity mapToStudentEntity(Student stu);
public Student mapToStudent(StudentEntity entity);
}

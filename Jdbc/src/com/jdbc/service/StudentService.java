package com.jdbc.service;

import java.util.List;

import com.jdbc.model.Student;

public interface StudentService {
public List<Student> getAllStudent();
public Student getOneStudent(int studentId);
public String updateStudent(Student stu);
public String deleteStudent(int studentId);
}

package com.service;

import java.util.List;

import com.model.Student;

public interface StudentService  {

	boolean addStudent(Student s);
	
	boolean deleteStudent(int id);
	
	boolean updateStudent(Student s);
	
	Student getStudentId(int id);
	
	List<Student> getAllStudents();
	
	List<Student> searchStudent(String data);
}

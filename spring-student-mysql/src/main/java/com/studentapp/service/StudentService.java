package com.studentapp.service;

import java.util.List;

import com.studentapp.model.Student;

public interface StudentService {

	void addStudent(Student student);
	List<Student> getStudentByCity(String city);
	List<Student> getAllStudents();
	
}

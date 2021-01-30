package com.studentapp.service;

import java.util.List;

import com.studentapp.model.Student;

public interface StudentService {

	void addStudent(Student student);
	List<Student> getStudentByCity(String city);
	List<Student> getAllStudents();
	List<Student> getByCourseName(String name);
	List<Student> getByCourseGadget(String cname, String gadget);
	void updateStudent(Integer id,String name);
	void deleteStudent(Integer id);
}

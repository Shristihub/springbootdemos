package com.studentapp.service;

import java.util.List;

import com.studentapp.exceptions.IdNotFoundException;
import com.studentapp.exceptions.StudentNotFoundException;
import com.studentapp.model.Student;

public interface StudentService {

	void addStudent(Student student);
	List<Student> getStudentByCity(String city) throws StudentNotFoundException;
	List<Student> getAllStudents();
	List<Student> getByCourseName(String name)throws StudentNotFoundException;
	List<Student> getByGadgets(String gadget) throws StudentNotFoundException;
	List<Student> getByCourseGadget(String cname, String gadget) throws StudentNotFoundException;
	void updateStudent(Integer id,String name)throws IdNotFoundException;
	void deleteStudent(Integer id)throws IdNotFoundException;
	Student getById(Integer id)throws IdNotFoundException;
}

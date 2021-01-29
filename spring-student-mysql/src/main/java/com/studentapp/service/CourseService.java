package com.studentapp.service;

import java.util.List;

import com.studentapp.model.Courses;
import com.studentapp.model.Student;

public interface CourseService {

	Courses getById(Integer id);
	List<Courses> findByStudent(String studName);
}

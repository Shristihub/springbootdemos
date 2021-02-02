package com.studentapp.service;

import java.util.List;

import com.studentapp.exceptions.CourseNotFoundException;
import com.studentapp.model.Courses;

public interface CourseService {

	Courses findById(Integer courseId) throws CourseNotFoundException;
	List<Courses> getCoursesByStudentId(Integer studentId) throws CourseNotFoundException;
	Courses getOneCourseByStudentId(int courseId,int studentId) throws CourseNotFoundException;
}

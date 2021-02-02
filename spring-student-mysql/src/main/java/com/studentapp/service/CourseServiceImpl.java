package com.studentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studentapp.dao.CourseRepository;
import com.studentapp.exceptions.CourseNotFoundException;
import com.studentapp.exceptions.IdNotFoundException;
import com.studentapp.model.Courses;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{

	@Autowired
	CourseRepository courseRepo;
	
	@Override
	public Courses findById(Integer courseId) {
		return courseRepo.findById(courseId)
		.orElseThrow(()-> new IdNotFoundException("Id not found"));
		
	}
	@Override
	public List<Courses> getCoursesByStudentId(Integer studentId) {
		List<Courses> courseList = courseRepo.findByStudentsStudentId(studentId);
		if (courseList.isEmpty())
			throw new CourseNotFoundException("Courses for student not available");
		return courseList;
	}
	
	@Override
	public Courses getOneCourseByStudentId(int courseId, int studentId) {
		Courses course = courseRepo.findbyStudentCourseId(studentId, courseId);
		if(course==null)
				throw new CourseNotFoundException("course with student id and courseid not available");
		return course;
	}

	
}

package com.studentapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studentapp.dao.CourseRepository;
import com.studentapp.model.Courses;
import com.studentapp.model.Student;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{

	@Autowired
	CourseRepository courseRepository;
	
	@Override
	public Courses getById(Integer id) {
		Optional<Courses> courseOpt = courseRepository.findById(id);
		if(courseOpt.isPresent()) {
			return courseOpt.get();
		}else {
			return null;
		}
	}

	@Override
	public List<Courses> findByStudent(String studName) {
		// TODO Auto-generated method stub
		return courseRepository.findByStudentsName(studName);
	}

	
	

}

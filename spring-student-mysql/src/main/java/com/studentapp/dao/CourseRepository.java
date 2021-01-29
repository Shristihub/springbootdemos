package com.studentapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentapp.model.Courses;

@Repository
public interface CourseRepository extends JpaRepository<Courses,Integer>{
	
	@EntityGraph("courses.student.graph")
	List<Courses> findByStudentsName(String student);
	
	
}


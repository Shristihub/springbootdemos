package com.studentapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.studentapp.model.Courses;

@Repository
public interface CourseRepository extends JpaRepository<Courses,Integer>{
	
	@EntityGraph("courses.student.graph")
	List<Courses> findByStudentsStudentId(Integer studentId);
	
	@Query("from Courses c inner join c.students s where s.studentId=?2 and c.courseId=?1")
	Courses findbyStudentCourseId(int courseId,int studentid);

	
	
}


package com.studentapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.studentapp.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

	//derived
//	List<Student> findByAddressCity(String city);
	
	@EntityGraph("student.graph")
	List<Student> findAll();
	
	@EntityGraph("student.graph")
	List<Student> findByGadgetsGadgetName(String name);
	
	@EntityGraph("student.graph")
	@Query("From Student s inner join s.address a WHERE a.city=?1 ")
	List<Student> findByAddressCity(String city);
	
	@EntityGraph("student.graph")
	@Query("FROM Student s INNER JOIN s.courses c WHERE c.courseName=?1")
	List<Student> findByCourseName(String coursename);
	
	@EntityGraph("student.graph")
	@Query("FROM Student s INNER JOIN s.courses c INNER JOIN s.gadgets g WHERE c.courseName=?1 AND g.gadgetName=?2")
	List<Student> findByCourseGadgets(String coursename, String gadgets);
	
	
}

//select * from student s inner join address a on s.address_id = a.address_id where a.city=?1
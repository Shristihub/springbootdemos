package com.studentapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.studentapp.model.Gadgets;

@Repository
public interface GadgetRepository extends JpaRepository<Gadgets,Integer>{
	
	@Query("from Gadgets g inner join g.student s where s.name=?1 ")
	List<Gadgets> findByStudentName(String student);
	
	
}


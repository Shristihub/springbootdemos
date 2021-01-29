package com.studentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studentapp.dao.StudentRepository;
import com.studentapp.model.Student;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentRepo;
	@Override
	public void addStudent(Student student) {
		studentRepo.save(student);
	}

	@Override
	public List<Student> getStudentByCity(String city) {
		return studentRepo.findByAddressCity(city);
	}

	@Override
	@Transactional
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}
	

}

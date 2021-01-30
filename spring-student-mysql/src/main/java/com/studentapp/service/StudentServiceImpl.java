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
@Profile("prod")
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentRepo;
	@Override
	public void addStudent(Student student) {
		studentRepo.save(student);
	}

	@Override
	public List<Student> getStudentByCity(String city) {
//		return studentRepo.findByAddressCity(city);
		return studentRepo.findByGadgetsGadgetName(city);
	}

	@Override
	@Transactional
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public List<Student> getByCourseName(String coursename) {
		return studentRepo.findByCourseName(coursename);
	}

	@Override
	public List<Student> getByCourseGadget(String coursename, String gadget) {
		return studentRepo.findByCourseGadgets(coursename, gadget);
	}

	@Override
	public void updateStudent(Integer id, String name) {
		Student stud = studentRepo.findById(id).get();
		stud.setName(name);
		studentRepo.save(stud);
		
	}

	@Override
	public void deleteStudent(Integer id) {
		studentRepo.deleteById(id);
	}
	

}

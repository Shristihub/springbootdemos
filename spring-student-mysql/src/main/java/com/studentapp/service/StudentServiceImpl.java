package com.studentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studentapp.dao.StudentRepository;
import com.studentapp.exceptions.IdNotFoundException;
import com.studentapp.exceptions.StudentNotFoundException;
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
		List<Student> studentList = studentRepo.findByAddressCity(city);
		if(studentList.isEmpty()) {
			throw new StudentNotFoundException("student for city not found");
		}
		return studentList;
		
	}

	@Override
	@Transactional
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public List<Student> getByCourseName(String coursename) {
		List<Student> studentList = studentRepo.findByCourseName(coursename);;
		if(studentList.isEmpty()) {
			throw new StudentNotFoundException("student for courses not found");
		}
		return studentList;
		
	}

	@Override
	public List<Student> getByCourseGadget(String coursename, String gadget) {
		List<Student> studentList = studentRepo.findByCourseGadgets(coursename, gadget);
		if(studentList.isEmpty()) {
			throw new StudentNotFoundException("student for coursename/gadgets not found");
		}
		return studentList;
		
	}

	@Override
	public void updateStudent(Integer id, String name) {
		Student stud = studentRepo.findById(id).get();
		stud.setName(name);
		studentRepo.save(stud);
		
	}

	@Override
	public void deleteStudent(Integer id) {
		if(id<=0) {
			throw new IdNotFoundException();
		}
		studentRepo.deleteById(id);
	}

	@Override
	public Student getById(Integer id) {
		return studentRepo.findById(id)
					.orElseThrow(()->new IdNotFoundException("Invalid id"));
	}

	@Override
	public List<Student> getByGadgets(String gadget) throws StudentNotFoundException {
		List<Student> studentList = studentRepo.findByGadgetsGadgetName(gadget);
		if(studentList.isEmpty()) {
			throw new StudentNotFoundException("student for coursename/gadgets not found");
		}
		return studentList;
	}
	

}

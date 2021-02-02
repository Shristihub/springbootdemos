package com.studentapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentapp.model.Student;
import com.studentapp.service.StudentService;

@RestController
@RequestMapping("/student-api")
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/students")
	ResponseEntity<Void> addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
		return ResponseEntity.ok().build();
	}
	@GetMapping("/student-by-id/{id}")
	ResponseEntity<Student>getStudentbyId(@PathVariable("id")Integer id){
		Student student = studentService.getById(id);
		return ResponseEntity.ok().body(student);
	}
	
	@GetMapping("/students-by-city/{city}")
	ResponseEntity<List<Student>> getStudentByCity(@PathVariable("city")String city){
		List<Student> studentList = studentService.getStudentByCity(city);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","By city");
		return ResponseEntity.ok().headers(headers).body(studentList);
	}
	@GetMapping("/students")
	ResponseEntity<List<Student>> getAllStudents(){
		List<Student> studentList = studentService.getAllStudents();
		return ResponseEntity.ok().body(studentList);
	}
	@GetMapping("/students-by-courses/{courseName}")
	ResponseEntity<List<Student>> getByCourseName(@PathVariable("courseName")String name){
		List<Student> studentList = studentService.getByCourseName(name);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","By courses");
		return ResponseEntity.ok().headers(headers).body(studentList);
	}
	@GetMapping("/students-by-courses-gadgets/{gadhetname}")
	ResponseEntity<List<Student>> getByGadgets(@PathVariable("gadgetname") String gadget){
		List<Student> studentList = studentService.getByGadgets(gadget);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","By gadgets");
		return ResponseEntity.ok().headers(headers).body(studentList);
	}
	@GetMapping("/students-by-courses-gadgets/{courseName}/{gadhetname}")
	ResponseEntity<List<Student>> getByCourseGadget(@PathVariable("courseName")String cname,@PathVariable("gadgetname") String gadget){
		List<Student> studentList = studentService.getByCourseGadget(cname, gadget);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","By courses/gadgets");
		return ResponseEntity.ok().headers(headers).body(studentList);
	}
	
	@PatchMapping("/students/{id}/{name}")
	ResponseEntity<Void> updateStudent(@PathVariable("id")Integer id,@PathVariable("name")String name){
		studentService.updateStudent(id, name);
		return ResponseEntity.ok().build();
	}
	@DeleteMapping("/students/{id}")
	ResponseEntity<Void> deleteStudent(@PathVariable("id")Integer id){
		studentService.deleteStudent(id);
		return ResponseEntity.ok().build();
	}
}

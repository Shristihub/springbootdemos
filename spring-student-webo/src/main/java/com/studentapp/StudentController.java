package com.studentapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.studentapp.model.Student;

@Controller
public class StudentController {

	@Autowired
	RestTemplate restTemplate;
	public static final String BASE_URL="http://localhost:8080/student-api";
	void addStudent(Student student) {
		
	}
	@GetMapping("/students-by-city")
	public String getStudentByCity(@RequestParam("city")String city,Model model){
		String url= BASE_URL+"/students-by-city/"+city;
		ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);
		List<Student> studentsList = response.getBody();
		model.addAttribute("studentsList", studentsList);
		return "home";
	}
	@GetMapping("/")
	public String getAllStudents(Model model){
		String url= BASE_URL+ "/students";
		ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);
		List<Student> studentsList = response.getBody();
		model.addAttribute("studentsList", studentsList);
		return "home";
	}
	@GetMapping("/students-by-courses")
	String getByCourseName(@RequestParam("courseName")String coursename,Model model){
		String url= BASE_URL+"/students-by-courses/"+coursename;
		ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);
		List<Student> studentsList = response.getBody();
		model.addAttribute("studentsList", studentsList);
		return "home";
	}
	@GetMapping("/students-by-gadgets")
	String getByGadgets(@RequestParam("gadget")String gadget,Model model) {
		String url= BASE_URL+"/students-by-gadgets/?gadgetname="+gadget;
		ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);
		List<Student> studentsList = response.getBody();
		model.addAttribute("studentsList", studentsList);
		return "home";
	}
	
	@GetMapping("/courses-by-students")
	String getByGadgets(@RequestParam("id")int id,Model model) {
		String url= BASE_URL+"/students-by-gadgets/?gadgetname="+gadget;
		ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);
		List<Student> studentsList = response.getBody();
		model.addAttribute("studentsList", studentsList);
		return "home";
	}
	
//	
//	void updateStudent(Integer id,String name) {
//		
//	}
//	Student getById(Integer id) {
//		
//	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e , Model model) {
		model.addAttribute("error",e.getMessage());
		return "home";
	}
}

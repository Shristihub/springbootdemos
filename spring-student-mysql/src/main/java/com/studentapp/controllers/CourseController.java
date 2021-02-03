package com.studentapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentapp.model.Courses;
import com.studentapp.model.Student;
import com.studentapp.service.CourseService;

@RestController
@RequestMapping("/course-api")
public class CourseController {

	@Autowired
	CourseService courseService;

	@GetMapping("/courses-by-student/{studentid}")
	ResponseEntity<List<Courses>> getCoursesByStudent(@PathVariable("studentid")int id){
		List<Courses> coursesList = courseService.getCoursesByStudentId(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc","By city");
		return ResponseEntity.ok().headers(headers).body(coursesList);
	}
	@GetMapping("/onecourse-by-student/{studentid}/{courseid}")
	ResponseEntity<Courses> getCoursesByStudent(@PathVariable("studentid")int studentId,@PathVariable("courseid")int courseId){
		Courses courses = courseService.getOneCourseByStudentId(courseId, studentId);
		return ResponseEntity.ok().body(courses);
	}
}

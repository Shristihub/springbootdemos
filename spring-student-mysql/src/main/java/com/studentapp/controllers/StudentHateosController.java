package com.studentapp.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentapp.model.Courses;
import com.studentapp.model.Gadgets;
import com.studentapp.model.Student;
import com.studentapp.service.CourseService;
import com.studentapp.service.GadgetService;
import com.studentapp.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentHateosController {

	@Autowired
	StudentService studentService;

	@Autowired
	CourseService courseService;
	@Autowired
	GadgetService gadgetService;

	
	@GetMapping(produces="application/hal+json")
	public CollectionModel<Student>  getStudents() {
		List<Student> studentList = studentService.getAllStudents();
		for(Student student:studentList) {
//			http://localhost:8080/students/1
			Link link = WebMvcLinkBuilder
						.linkTo(StudentHateosController.class)
						.slash(student.getStudentId())
						.withSelfRel();
			student.add(link);
//			http://localhost:8080/students/1/gadgets
//			Link gadgets1Link = linkTo(StudentHateosController.class)
//					.slash(student.getStudentId())
//					.slash("gadgets")
//					.withRel("gad");
			Link gadgetsLink = linkTo(
					methodOn(StudentHateosController.class)
					.getGadgetsByStudentID(student.getStudentId()))
					.withRel("all_gadget");
			student.add(gadgetsLink);
			
			Link coursesLink = linkTo(
					methodOn(StudentHateosController.class).getCoursesByStudentID(student.getStudentId()))
					.withRel("all_courses");
			student.add(coursesLink);							
					
		}
		Link mainLink = linkTo(StudentHateosController.class).withSelfRel();
		CollectionModel<Student> studentModel = CollectionModel.of(studentList,mainLink);
		return studentModel;
	}
	@GetMapping(value="/{studentId}", produces = "application/hal+json")
	public Student getById(@PathVariable("studentId")int studentId) {
		return studentService.getById(studentId);
		
		
		
		
	}
//	http://localhost:8080/students/1/gadgets
	@GetMapping(value="/{studentId}/gadgets", produces = "application/hal+json")
	public CollectionModel<Gadgets> getGadgetsByStudentID(@PathVariable("studentId")int studentId) {
		List<Gadgets> gadgetList = gadgetService.getGadgetsByStudentId(studentId);
		for (Gadgets gadgets : gadgetList) {
//			http://localhost:8080/students/1/51
//			Link selfLink = linkTo(StudentHateosController.class)
//								.slash(studentId)
//								.slash("gadgets")
//								.slash(gadgets.getGadgetId())
//								.withSelfRel();
			Link selfLink = linkTo(
					methodOn(StudentHateosController.class).getOneGadgetByStudentID(studentId, gadgets.getGadgetId()))
					.withSelfRel();
			gadgets.add(selfLink);
		}
		Link mainLink = linkTo(StudentHateosController.class).withSelfRel();
		CollectionModel<Gadgets> gadgetModel = CollectionModel.of(gadgetList,mainLink);
		return gadgetModel;
		
	}
	@GetMapping(value="/{studentId}/gadgets/{gadgetId}", produces = "application/hal+json")
	public Gadgets getOneGadgetByStudentID(@PathVariable("studentId")int studentId,
								@PathVariable("gadgetId")int gadgetId) {
		return gadgetService.getOneGadgetByStudentId(gadgetId, studentId);
		
	}
		//	http://localhost:8080/students/1/courses
		@GetMapping(value="/{studentId}/courses", produces = "application/hal+json")
		public CollectionModel<Courses> getCoursesByStudentID(@PathVariable("studentId")int studentId) {
			List<Courses> coursesList = courseService.getCoursesByStudentId(studentId);
			for (Courses course : coursesList) {
//				http://localhost:8080/students/1/90
				Link selfLink = linkTo(StudentHateosController.class)
									.slash(studentId)
									.slash("courses")
									.slash(course.getCourseId())
									.withSelfRel();
				course.add(selfLink);
			}
			Link mainLink = linkTo(StudentHateosController.class).withSelfRel();
			CollectionModel<Courses> gadgetModel = CollectionModel.of(coursesList,mainLink);
			return gadgetModel;
			
		}
		@GetMapping(value="/{studentId}/courses/{courseId}", produces = "application/hal+json")
		public Courses getOneCourseByStudentID(@PathVariable("studentId")int studentId,
									@PathVariable("courseId")int courseId) {
			return courseService.getOneCourseByStudentId(courseId, studentId);
			
		}

}










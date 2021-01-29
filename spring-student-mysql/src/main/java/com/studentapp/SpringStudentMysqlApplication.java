package com.studentapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studentapp.model.Address;
import com.studentapp.model.Courses;
import com.studentapp.model.Gadgets;
import com.studentapp.model.Student;
import com.studentapp.service.CourseService;
import com.studentapp.service.GadgetService;
import com.studentapp.service.StudentService;

@SpringBootApplication
public class SpringStudentMysqlApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringStudentMysqlApplication.class, args);
	}
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	GadgetService gadgetService;
	
	@Override
	public void run(String... args) throws Exception {
//		Address address= new Address(13,"Bangalore","Kar");		
//		List<Gadgets> gadgets = Arrays.asList(new Gadgets(55,"Headphones","K90"),new Gadgets(56,"Laptop","T430"));
//		Set<Gadgets> gadgetList = new HashSet<>(gadgets);
////		
////		Courses course1 = new Courses(4,"Microservice",2000);
////		Courses course2 = new Courses(5,"Angular",1200);
////		Courses course3 = new Courses(6,"CSS",3000);
//		
//		Courses course1 = courseService.getById(4);
//		Courses course2 = courseService.getById(5);
//		
//		Set<Courses> courseList = new HashSet<>(Arrays.asList(course1,course2));
//		
//		Student student =new Student(103,"Kumaran",address,gadgetList,courseList);
//		studentService.addStudent(student);
//		
		studentService.getAllStudents().forEach((nstudent)->{
			System.out.println(nstudent.getName());
//			nstudent.getCourses().forEach((course)->System.out.print(course.getCourseName())));
			System.out.println(nstudent.getAddress().getCity());
		});
		System.out.println();
		studentService.getStudentByCity("Mobile").forEach(System.out::println);
		System.out.println();
//		studentService.getByCourseName("Angular").forEach((nstudent)->{
//			System.out.println(nstudent.getName());
////			nstudent.getCourses().forEach((course)->System.out.print(course.getCourseName())));
//			System.out.println(nstudent.getAddress().getCity());
//			Set<Gadgets> gadgetsList  = nstudent.getGadgets();
//			gadgetsList.forEach(System.out::println);
//		});
//		studentService.getByCourseGadget("Angular", "Mobile").forEach((nstudent)->{
//			System.out.println(nstudent.getName());
////			nstudent.getCourses().forEach((course)->System.out.print(course.getCourseName())));
//			System.out.println(nstudent.getAddress().getCity());
//			Set<Gadgets> gadgetsList  = nstudent.getGadgets();
//			gadgetsList.forEach(System.out::println);
//			System.out.println(nstudent.getCourses());
//		});
		
		List<Courses> courseList = courseService.findByStudent("Rohan");
		for (Courses courses : courseList) {
			System.out.println(courses.getCourseName()+" "+courses.getCost());
		}
		
		gadgetService.findByStudentName("Rohan").forEach((gadget)->{
			System.out.println(gadget.getGadgetName()+""+gadget.getGadgetModel());
		});
	}
}

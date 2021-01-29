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
import com.studentapp.service.StudentService;

@SpringBootApplication
public class SpringStudentMysqlApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringStudentMysqlApplication.class, args);
	}
	
	@Autowired
	StudentService studentService;
	@Override
	public void run(String... args) throws Exception {
//		Address address= new Address(12,"Bangalore","Kar");		
//		List<Gadgets> gadgets = Arrays.asList(new Gadgets(53,"Mobile","A123"),new Gadgets(54,"Xbox","T430"));
//		Set<Gadgets> gadgetList = new HashSet<>(gadgets);
//		
//		Courses course1 = new Courses(4,"Microservice",2000);
//		Courses course2 = new Courses(5,"Angular",1200);
//		Courses course3 = new Courses(6,"CSS",3000);
//		Set<Courses> courseList = new HashSet<>(Arrays.asList(course1,course2,course3));
//		
//		Student student =new Student(102,"Revanth",address,gadgetList,courseList);
//		studentService.addStudent(student);
//		
//		studentService.getAllStudents().forEach((nstudent)->{
//			System.out.println(nstudent.getName());
////			nstudent.getCourses().forEach((course)->System.out.print(course.getCourseName())));
//			System.out.println(nstudent.getAddress().getCity());
//		});
//		
		studentService.getStudentByCity("Bangalore").forEach(System.out::println);
		
	}
}

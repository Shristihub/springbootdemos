package com.studentapp.model;

import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"courseId","students"})
public class Courses {

	private Integer courseId;
	private String courseName;
	private double cost;
	private Set<Student> students;
	
	public Courses(Integer courseId, String courseName, double cost) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.cost = cost;
	}
	

	
	
	
}

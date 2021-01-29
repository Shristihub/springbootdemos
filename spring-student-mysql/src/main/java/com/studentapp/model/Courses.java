package com.studentapp.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Courses {

	@Id
	private Integer courseId;
	private String courseName;
	private double cost;
	@ManyToMany(mappedBy="courses")
	private Set<Student> students;
	
	public Courses(Integer courseId, String courseName, double cost) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Courses [courseName=" + courseName + ", cost=" + cost + "]";
	}

	
	
	
}

package com.studentapp.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@NamedEntityGraph(
		name="courses.student.graph",
		attributeNodes = {
				@NamedAttributeNode("students")
		})
public class Courses {

	@Id
	private Integer courseId;
	private String courseName;
	private double cost;
	@ManyToMany(mappedBy="courses")//, fetch = FetchType.EAGER)
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

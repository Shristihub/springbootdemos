package com.studentapp.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString(exclude = {"courseId","students"})
@NamedEntityGraph(
		name="courses.student.graph",
		attributeNodes = {
				@NamedAttributeNode("students")
		})
@Audited
public class Courses {

	@Id
	private Integer courseId;
	private String courseName;
	private double cost;
	@ManyToMany(mappedBy="courses")//, fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Student> students;
	
	public Courses(Integer courseId, String courseName, double cost) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.cost = cost;
	}
	

	
	
	
}

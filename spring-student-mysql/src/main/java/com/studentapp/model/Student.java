package com.studentapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@NamedEntityGraph(
		name="student.graph",
		attributeNodes= {
				@NamedAttributeNode("address"),
				@NamedAttributeNode("gadgets"),
				@NamedAttributeNode("courses")
		}
		)

public class Student {

	@Id 
	private Integer studentId;
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id")
	Address address;
	
	@OneToMany(cascade = CascadeType.ALL)//,fetch = FetchType.EAGER)
	@JoinColumn(name="student_id")
	Set<Gadgets> gadgets;
	
	@ManyToMany(cascade = CascadeType.ALL)//,fetch = FetchType.EAGER)
	@JoinTable(name="student_courses",
				joinColumns = @JoinColumn(name="student_id"),
				inverseJoinColumns = @JoinColumn(name="courses_id")
			)
	Set<Courses> courses;
}


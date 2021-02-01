package com.studentapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@NamedEntityGraph(name = "student.graph", attributeNodes = { @NamedAttributeNode("address"),
		@NamedAttributeNode("gadgets"), @NamedAttributeNode("courses") })
//@EntityListeners(value = StudentAuditListener.class)
@Audited
public class Student {// extends Auditable<String>{

	@Id
	private Integer studentId;
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	Address address;

	@OneToMany(cascade = CascadeType.ALL) // ,fetch = FetchType.EAGER)
	@JoinColumn(name = "student_id")
	@NotAudited
	Set<Gadgets> gadgets;

	@ManyToMany(cascade = CascadeType.ALL) // ,fetch = FetchType.EAGER)
	@JoinTable(name = "student_courses", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "courses_id"))
	Set<Courses> courses;

//	@PrePersist
//	public void beforeInserting() {
//		audit("before", "inserting");
//	}
//
//	@PostPersist
//	public void afterInserting() {
//		audit("after", "inserting");
//	}
//
//	@PreUpdate
//	public void beforeUpdating() {
//		audit("before", "updating");
//	}
//
//	@PostUpdate
//	public void afterUpdating() {
//		audit("after", "updating");
//	}
//
//	@PreRemove
//	public void beforeRemoving() {
//		audit("before", "removing");
//	}
//
//	@PostRemove
//	public void afterRemoving() {
//		audit("after", "removing");
//	}
//
//	public void audit(String type, String operation) {
//		System.out.println(type + " " + operation);
//	}
}

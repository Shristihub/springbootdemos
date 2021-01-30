package com.studentapp.service;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import com.studentapp.model.Student;

public class StudentAuditListener {
	
	@PrePersist
	@PreUpdate
	@PreRemove
	public void beforeOperation(Object object) {
		Student st = (Student)object;
		System.out.println("before "+ st);
	}
	@PostPersist
	@PostUpdate
	@PostRemove
	public void afterOperation(Object object) {
		Student st = (Student)object;
		System.out.println("before "+ st);
	}
}

package com.studentapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Courses {

	@Id
	private Integer courseId;
	private String courseName;
	private double cost;
	
	
}

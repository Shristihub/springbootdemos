package com.studentapp.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {

	private Integer studentId;
	private String name;

	Address address;

	Set<Gadgets> gadgets;

	Set<Courses> courses;
}

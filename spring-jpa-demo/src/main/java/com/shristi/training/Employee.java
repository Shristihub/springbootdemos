package com.shristi.training;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Employee {
	
	
	private String name;
	@Id
	@GeneratedValue
	private Integer empId;
	
	public Employee(String name, Integer empId) {
		super();
		this.name = name;
		this.empId = empId;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", empId=" + empId + "]";
	}
	
}

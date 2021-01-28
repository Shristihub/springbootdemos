package com.shristi.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com");
		EmpService service = context.getBean(EmpService.class);
		service.addEmployee(new Employee("Rohan",12));
	}

}

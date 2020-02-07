package com.autowire.training;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
@SpringBootApplication
public class TestAutowire implements CommandLineRunner{
/*	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext("com.autowire");
		ShapeFactory factory=(ShapeFactory)context.getBean("shapeFactory");
		Shape shape = factory.getShape();
		factory.printArea(10,20);
	}*/
	
	@Autowired
	ShapeFactory factory;
	public static void main(String[] args) {
		SpringApplication.run(TestAutowire.class, args);
		
	}

public void run(String... args) throws Exception {
	Shape shape = factory.getShape();
	System.out.println(shape.calcArea(10,20));
}
		

}
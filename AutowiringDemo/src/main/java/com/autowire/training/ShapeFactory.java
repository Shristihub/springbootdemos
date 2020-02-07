package com.autowire.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ShapeFactory {
	@Autowired
	@Qualifier("square")
	Shape shape;
	
	public Shape getShape() {
		return shape;
	}
	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public void printArea(int x, int y) {
		
		System.out.print("Calculating Area");
		System.out.println(shape.calcArea(x, y));

	}
}

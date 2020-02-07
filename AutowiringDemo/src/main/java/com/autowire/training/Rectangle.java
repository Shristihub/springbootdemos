package com.autowire.training;

import org.springframework.stereotype.Component;

@Component("shape")
public class Rectangle  implements Shape {

	public double calcArea(int x, int y) {
		System.out.println("rectangle");
		return x*y;
	}

}

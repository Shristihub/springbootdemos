package com.autowire.training;

import org.springframework.stereotype.Component;

@Component
public class Square  implements Shape {


	public double calcArea(int x, int y) {
		System.out.println("Square");
		return x*x;
	}
	
}

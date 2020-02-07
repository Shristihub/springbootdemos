package com.autowire.training;

import org.springframework.stereotype.Component;

@Component
public class Triangle  implements Shape{

	public double calcArea(int x,int y) {
		System.out.println("triangle");
		return 0.5*x*y;
		
	}
	
}



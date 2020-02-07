package com.example.service;

import org.springframework.stereotype.Component;

@Component
public class GreetServiceImpl implements GreetService{

	@Override
	public String greetMessage(String name) {
		return "Have a good day "+name ;
	}

}

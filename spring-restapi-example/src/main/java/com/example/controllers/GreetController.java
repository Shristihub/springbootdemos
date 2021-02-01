package com.example.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class GreetController {

	@RequestMapping("/greet/{username}")
	public String greet(@PathVariable("username")String name) {
		return "Have a great day "+name;
	}
	@RequestMapping(value = "/hello", method=RequestMethod.GET)
	public List<String> sayHello() {
		return Arrays.asList("Java","Hello"," MVC");
		}
	
	
}

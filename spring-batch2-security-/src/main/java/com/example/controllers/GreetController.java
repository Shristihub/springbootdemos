package com.example.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

	@RequestMapping(value = "/")
	public String greet() {
		return "welcome";
	}
	@RequestMapping(value = "/api/greetMessage")
	public String greetMessage() {
		return "have a great day";
	}
	
	@RequestMapping(value = "/admin/update",method = RequestMethod.GET)
	public String sayHello() {
		return "Hello MVC from admin";
	}
	@RequestMapping(value = "/admin/add")
	public String greetAdminMessage() {
		return "have a great day from admin";
	}
	@RequestMapping(value = "/api/sayHello",method = RequestMethod.GET)
	public String sayAdminHello() {
		return "Hello MVC";
	}
}

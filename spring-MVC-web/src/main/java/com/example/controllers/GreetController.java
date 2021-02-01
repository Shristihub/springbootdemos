package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetController {

	@RequestMapping("/greet")
	public String greet(Model map) {
		map.addAttribute("message","Have a great day");
		return "success";
	}
	@RequestMapping(value = "/hello", method=RequestMethod.GET)
	public String sayHello(ModelMap map) {
		map.addAttribute("message"," Hello MVC");
		return "success";
	}
	
	@GetMapping("/welcome")
	public ModelAndView welcome() {
		ModelAndView model = new ModelAndView("success","message","Welcome to MVC");
		return model;
	}
}

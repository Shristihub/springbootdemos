package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.service.BookService;
import com.example.service.GreetService;

@SpringBootApplication
public class SpringDemoAllApplication implements CommandLineRunner{
	@Autowired
	GreetService greetService;
	@Autowired
	BookService bookService;
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringDemoAllApplication.class);
		app.run();
	}
	@Override
	public void run(String... arg0) throws Exception {
		String val = greetService.greetMessage("Ram");
		System.out.println(val);
		System.out.println();
		System.out.println(bookService.getBookById(1));
		System.out.println();
		System.out.println(bookService.getAllBooks());
	}

	
}

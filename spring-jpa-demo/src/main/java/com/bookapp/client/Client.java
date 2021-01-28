package com.bookapp.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bookapp.model.Book;
import com.bookapp.service.BookService;

public class Client {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.bookapp");
		BookService bookService = context.getBean(BookService.class);
		bookService.addBook(new Book("Java","Kathy","Tech",900));
		bookService.getAll().forEach(System.out::println);
	}
}

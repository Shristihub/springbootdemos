package com.bookapp.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bookapp.model.Book;
import com.bookapp.service.BookService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.bookapp");
		BookService service = context.getBean(BookService.class);
		Book book  = new Book();
		book.setTitle("Java");
		book.setAuthor("Kathy");
		book.setCategory("Tech");
		book.setPrice(1000);
		//service.addBook(book);
		
		service.getAll().forEach(System.out::println);
	}
}

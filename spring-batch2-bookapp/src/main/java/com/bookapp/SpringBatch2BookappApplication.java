package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.model.Book;
import com.bookapp.service.BookService;

@SpringBootApplication
public class SpringBatch2BookappApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBatch2BookappApplication.class, args);
	}

	@Autowired
	BookService bookService;
	
	@Override
	public void run(String... args) throws Exception {

		bookService.addBook(new Book("Miracl","Hal","Self",1800));
		bookService.getAll().forEach(System.out::println);
		System.out.println();
		
		Book book = bookService.getById(1);
		System.out.println(book);
		
//		bookService.getByAuthor("Steve").forEach((book)->System.out.println(book));
		System.out.println();
		
	}

}

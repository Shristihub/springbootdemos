package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.model.Book;
import com.bookapp.service.BookProjectionService;
import com.bookapp.service.BookService;

@SpringBootApplication
public class OnlineBookApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OnlineBookApplication.class, args);
	}
	@Autowired
	BookService bookService;
	
	@Autowired
	BookProjectionService bookProjectionService;
	
	@Override
	public void run(String... args) throws Exception {
		//bookService.addBook(new Book("Java","Kathy","Tech",900));
//		bookService.getAll().forEach(System.out::println);
		
//		System.out.println();
//		Book book = bookService.getById(10);
//		System.out.println(book);
//		System.out.println();
//		bookService.getByAuthor("Kevin").forEach(System.out::println);
//		System.out.println();
//		bookService.getByCategory("Self").forEach(System.out::println);
//		bookService.getByPrice(1200.0).forEach(System.out::println);
		
//		bookService.getByAuthCat("Merlin","Self").forEach(System.out::println);
//		bookService.getByAuthor("K").forEach(System.out::println);
		
//		bookService.getByTitleLength(10).forEach(System.out::println);
//		bookService.updateBook(6, 2600.8);
//		bookService.deleteBook(13);;
		
//		bookService.getBooksByPage(1,6).forEach(System.out::println);
		
		bookProjectionService.getAllTitles().forEach((bookInfo)->System.out.println(bookInfo.getTitle()));
		
	}

}

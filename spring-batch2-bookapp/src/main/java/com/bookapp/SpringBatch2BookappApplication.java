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

//		bookService.addBook(new Book("Skull Daggery","Derek","Fiction",450));
//		bookService.getAll().forEach(System.out::println);
		System.out.println();
//		
//		Book book = bookService.getById(1);
//		System.out.println(book);
//			
//		
//		bookService.getByAuthor("M").forEach((nbook)->System.out.println(nbook));
		System.out.println();
//		bookService.getByCategory("Self").forEach(System.out::println);
//		System.out.println();
//		bookService.getByPrice(1000).forEach(System.out::println);
//		System.out.println();
		
//		bookService.findByCatPrice("Self",1000.0).forEach((nbook)->System.out.println(nbook));
//		bookService.findByCategoryAuthor("Self","Merlin").forEach((nbook)->System.out.println(nbook));
		
//		bookService.getSortedByTitle("Merlin").forEach((nbook)->System.out.println(nbook));
//		bookService.getCatByPages("Self").forEach((nbook)->System.out.println(nbook));
		
//		bookService.getAllCols().forEach((bookInfo)->System.out.println(bookInfo.getTitle()));
//		System.out.println();
//		bookService.getAllCols().forEach((bookInfo)->System.out.println(bookInfo.getAuthor()));
		
//		bookService.getAllCols().forEach((bookInfo)->System.out.println(bookInfo.getTitleAuthor()));
//		bookService.getAllCols().forEach((bookInfo)->
//		      System.out.println(bookInfo.getLabeledTitleAuthor("Title","Author")));
//		bookService.getAllCols().forEach((bookInfo)->
//	      System.out.println(bookInfo.displayBook()));
		
	
		
		
		
		
		
		
		
		
		
		
		
	}

}

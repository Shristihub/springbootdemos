package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.Book;
import com.bookapp.service.BookService;

//@RestController
//@RequestMapping("/book-api")
public class BookResponseController {

	@Autowired
	BookService bookService;
	
	@PostMapping("/books")
	public void addBook(@RequestBody Book book) {
		
		bookService.addBook(book);
	}
	
	@GetMapping("/book-by-id/{bookId}")
	public ResponseEntity<Book> getById(@PathVariable("bookId")Integer bookId) {
		Book book = bookService.getById(bookId);
		ResponseEntity<Book> bookResponse = new ResponseEntity<Book>(book, HttpStatus.OK);
		return bookResponse;
	}
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAll(){
		ResponseEntity<List<Book>> bookResponse = ResponseEntity.ok().body(bookService.getAll()); 
		return bookResponse;
	}
//	http://localhost:8080/book-api/books-by-category/Kevin
	@GetMapping("/books-by-author/{author}")
	public ResponseEntity<List<Book>> getByAuthor(@PathVariable("author")String author){
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Books by author "+author);
		headers.add("details", "Book details");
		List<Book> bookList = bookService.getByAuthor(author);
		ResponseEntity<List<Book>> bookResponse = new ResponseEntity<List<Book>>(bookList, headers, HttpStatus.ACCEPTED); 
		return bookResponse;
	}
	
//	http://localhost:8080/book-api/books-by-category?category=Fiction
	@GetMapping("/books-by-category")
	public List<Book> getByCategory(@RequestParam("category")String category){
		return bookService.getByCategory(category);
	}
}

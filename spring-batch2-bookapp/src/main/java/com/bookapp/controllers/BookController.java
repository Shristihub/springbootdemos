package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.Book;
import com.bookapp.service.BookService;

@RestController
@RequestMapping("/book-api")
public class BookController {

	@Autowired
	BookService bookService;
	@GetMapping("/book-by-id/{bookId}")
	public Book getById(@PathVariable("bookId")Integer bookId) {
		return bookService.getById(bookId);
	}
	@GetMapping("/books")
	public List<Book> getAll(){
		return bookService.getAll();
	}
//	http://localhost:8080/book-api/books-by-category/Kevin
	@GetMapping("/books-by-author/{author}")
	public List<Book> getByAuthor(@PathVariable("author")String author){
		return bookService.getByAuthor(author);
	}
//	http://localhost:8080/book-api/books-by-category?category=Fiction
	@GetMapping("/books-by-category")
	public List<Book> getByCategory(@RequestParam("category")String category){
		return bookService.getByCategory(category);
	}
}

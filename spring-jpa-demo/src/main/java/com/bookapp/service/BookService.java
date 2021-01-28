package com.bookapp.service;

import java.util.List;

import com.bookapp.model.Book;

public interface BookService {
	void addBook(Book book);
	Book getById(Integer bookid);
	List<Book> getAll();
	List<Book> getByAuthor(String author);
	
}

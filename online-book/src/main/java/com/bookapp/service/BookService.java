package com.bookapp.service;

import java.util.List;

import com.bookapp.model.Book;

public interface BookService {
	void addBook(Book book);
	Book getById(Integer bookId);
	List<Book> getAll();
	List<Book> getByAuthor(String author);
	List<Book> getByCategory(String category);
	void deleteBook(int bookid);
	List<Book> getByPrice(double price);
	List<Book> getByAuthCat(String author,String category);
}


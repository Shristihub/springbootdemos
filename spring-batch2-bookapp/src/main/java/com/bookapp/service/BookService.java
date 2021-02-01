package com.bookapp.service;

import java.util.List;

import com.bookapp.dao.BookInfo;
import com.bookapp.model.Book;

public interface BookService {
	
	void addBook(Book book);
	void deleteBook(int bookId);
	Book getById(Integer bookId);
	List<Book> getAll();
	List<Book> getByAuthor(String author);
	List<Book> getByCategory(String category);
	List<Book> getByPrice(double price);
	
	List<Book> findByCatPrice(String category, double price);
	List<Book> findByCategoryAuthor(String category, String author);
	
	public List<Book> getSortedByTitle(String author) ;
	public List<Book> getCatByPages(String category);
	
	
	List<BookInfo> getAllCols();
	
}

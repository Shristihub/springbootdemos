package com.bookapp.dao;

import java.util.List;

import com.bookapp.model.Book;

public interface BookDAO {
	void addBook(Book book);
	Book getById(Integer bookid);
	List<Book> getAll();
	List<Book> getByAuthor(String author);
	
}

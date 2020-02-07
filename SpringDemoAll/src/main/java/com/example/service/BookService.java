package com.example.service;

import java.util.List;

public interface BookService {

	Book getBookById(int id);
	List<Book> getAllBooks();
}

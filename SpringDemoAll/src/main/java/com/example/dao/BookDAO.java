package com.example.dao;

import java.util.List;

import com.example.service.Book;

public interface BookDAO {
	Book getBookById(int id);
	List<Book> getAllBooks();
}

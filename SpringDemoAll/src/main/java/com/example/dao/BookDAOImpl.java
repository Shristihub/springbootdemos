package com.example.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.service.Book;
@Repository
//@Scope("prototype")
public class BookDAOImpl implements BookDAO {

	@Override
	public Book getBookById(int id) {
		if (id == 1) {
			return new Book("Java in Action", 300);
		} else
			return new Book("Spring Boot", 900);
	}

	@Override
	public List<Book> getAllBooks() {
		return 
	Arrays.asList(new Book("Spring", 300), new Book("Java ", 500), new Book("Spring Boot", 300));
	}

}

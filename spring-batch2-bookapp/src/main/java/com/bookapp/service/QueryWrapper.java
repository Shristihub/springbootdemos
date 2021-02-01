package com.bookapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class QueryWrapper {

	String allBooks;

	public String getAllBooks() {
		return allBooks;
	}
	@Value("${findAll}")
	public void setAllBooks(String allBooks) {
		this.allBooks = allBooks;
	}
	
}

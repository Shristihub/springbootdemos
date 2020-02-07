package com.example.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BookDAO;
@Service
public class BookServiceImpl implements BookService {

	@Autowired	
	BookDAO bookDAO;
	
	public BookDAO getBookDAO() {
		return bookDAO;
	}

	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	@Override
	public Book getBookById(int id) {
		return bookDAO.getBookById(id);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookDAO.getAllBooks();
	}

}

package com.bookapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.dao.BookDAO;
import com.bookapp.model.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDAO bookDAO;
	
	@Override
	public void addBook(Book book) {
		bookDAO.save(book);
	}

	@Override
	public void deleteBook(int bookid) {
		bookDAO.deleteById(bookid);
		
	}

	@Override
	public Book getById(Integer bookId) {
		Optional<Book> optBook = bookDAO.findById(bookId);
		if(optBook.isPresent())
			return optBook.get();
		else 
			return null;
		
	}

	@Override
	public List<Book> getAll() {
		return (List<Book>) bookDAO.findAll();
	}

	@Override
	public List<Book> getByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getByPrice(double price) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

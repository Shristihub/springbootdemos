package com.bookapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.dao.BookDAO;
import com.bookapp.model.Book;
@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDAO bookDAO;
	@Override
	public void addBook(Book book) {
		bookDAO.save(book);

	}
	@Override
	public Book getById(Integer bookId) {
		Optional<Book> optBook = bookDAO.findById(bookId);
		if(optBook.isPresent()) {
			return optBook.get();
		}else
			return null;
	}

	@Override
	public List<Book> getAll() {
		return bookDAO.findAll();
	}

	@Override
	public List<Book> getByAuthor(String author) {
//		return bookDAO.findByAuthor(author);
		return bookDAO.findByAuthStarting(author);
	}

	@Override
	public List<Book> getByCategory(String category) {
		return bookDAO.readByCategory(category);
	}
	@Override
	public List<Book> getByAuthCat(String author,String category) {
		return bookDAO.findByAuthCat(author, category);
	}

	@Override
	public void deleteBook(int bookid) {
		bookDAO.deleteById(bookid);
	}
	@Override
	public List<Book> getByPrice(double price) {
		
		return bookDAO.findByPriceLessThan(price);
	}

	
}

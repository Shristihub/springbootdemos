package com.bookapp.service;

import java.util.List;

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
		bookDAO.addBook(book);
		
	}

	@Override
	public Book getById(Integer bookId) {
		return bookDAO.getById(bookId);
	}

	@Override
	public List<Book> getAll() {
		return bookDAO.getAll();
	}

	@Override
	public List<Book> getByAuthor(String author) {
		return bookDAO.getByAuthor(author);
	}

	
	
	
	
//	private List<Book> showBooks(){
//		return Arrays.asList(
//				new Book("Java",10,"Kathy","Tech",1000),
//				new Book("Java",11,"Rod","Tech",1000),
//				new Book("Java",12,"Kathy","Tech",1000),
//				new Book("Habbits",13,"Steve","Tech",1000),
//				new Book("Java",14,"Steve","Tech",1000));
//	}

}

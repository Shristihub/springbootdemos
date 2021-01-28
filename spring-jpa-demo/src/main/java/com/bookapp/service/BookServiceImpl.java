package com.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.dao.BookDAO;
import com.bookapp.model.Book;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookDAO bookDAO;
//	@Override
	public List<Book> getAll() {
		return bookDAO.getAll();
	}

//	@Override
	public List<Book> getByAuthor(String author) {
		return bookDAO.getByAuthor(author);
	}

//	@Override
	public void addBook(Book book) {
		bookDAO.addBook(book);
	}

//	@Override
	public Book getById(Integer bookid) {
		return bookDAO.getById(bookid);
	}

//	private List<Book> showBooks(){
//		return Arrays.asList(
//				new Book("Java","Kathy","Tech",10,900),
//				new Book("JSP","Steve","Tech",11,900),
//				new Book("Spring","Steve","Tech",12,900),
//				new Book("Microservices","Rod","Tech",13,900),
//				new Book("Java","John","Tech",14,900),
//				new Book("Javascript","Kathy","Tech",15,900));
//	}
}

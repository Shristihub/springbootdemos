package com.bookapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bookapp.dao.BookInfo;
import com.bookapp.dao.BookRepository;
import com.bookapp.dao.BookSortRepository;
import com.bookapp.model.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookDAO;
	
	@Autowired
	BookSortRepository bookSortRepo;
	
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
	
//	
	
	@Override
	public List<Book> getAll() {
//		return bookDAO.findAll();
		//return bookDAO.findAll(Sort.by(Sort.Direction.ASC,"title"));
		Pageable firstPage = PageRequest.of(0,5, Sort.by("title").descending());
		return bookDAO.findAll(firstPage).toList();
		
	}
	
	@Override
	public List<Book> getSortedByTitle(String author) {
		return bookSortRepo.findByAuthor(author, Sort.by("title","price").descending());
	}

	@Override
	public List<Book> getByAuthor(String author) {
//		return bookDAO.findByAuthor(author);
//		return bookDAO.findByAuthorStartingWith(author);
		return bookDAO.findByAuthorPrefix(author);
	}

	@Override
	public List<Book> getByCategory(String category) {
		return bookDAO.readByCategory(category);
	}

	@Override
	public List<Book> getCatByPages(String category) {
		Pageable firstPage = PageRequest.of(1,5);
		return bookSortRepo.readByCategory(category,firstPage);
	}


	@Override
	public List<Book> getByPrice(double price) {
		return bookDAO.findByPriceLessThan(price);
	}

	@Override
	public List<Book> findByCatPrice(String category, double price) {
		return bookDAO.findByCatPrice(category, price);
	}

	public List<Book> findByCategoryAuthor(String category, String author){
		return bookDAO.findByCategoryAuthor(category, author);
	}

	@Override
	public List<BookInfo> getAllCols() {
		return bookSortRepo.findBy(Sort.by("title").descending());
	}
}

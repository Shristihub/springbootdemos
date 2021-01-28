package com.bookapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookapp.dao.BookRepository;
import com.bookapp.model.Book;
@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookDAO;
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

	// sorting
	@Override
	public List<Book> getAll() {
//		return bookDAO.findAll();
//		return bookDAO.findAll(Sort.by(Sort.Direction.ASC, "title"));
//		return bookDAO.findAll( Sort.by("title","category").descending());
		return bookDAO.findSortedBooks(Sort.by(Sort.Direction.ASC, "title_length"));
	}
	@Override
	public List<Book> getBooksByPage(int pageNum,int count) {
//		Pageable fpage = PageRequest.of(pageNum,count);
		Pageable fpage = PageRequest.of(pageNum,count,Sort.by("title"));
		return bookDAO.findAll(fpage).toList();
	}

	@Override
	public List<Book> getByAuthor(String author) {
		return bookDAO.findByAuthor(author, Sort.by("title").descending());
//		return bookDAO.findByAuthStarting(author);
	}

	@Override
	public List<Book> getByCategory(String category) {
//		return bookDAO.readByCategory(category);
		return bookDAO.findBookWithCat(category);
		
	}
	@Override
	public List<Book> getByAuthCat(String author,String category) {
		return bookDAO.findByAuthCat(author, category);
	}

	@Override
	@Transactional
	public void deleteBook(int bookid) {
		bookDAO.deleteById(bookid);
	}
	@Override
	public List<Book> getByPrice(double price) {
		
		return bookDAO.findByPriceLessThan(price);
	}
	@Override
	public List<Book> getByTitleLength(int length) {
		// TODO Auto-generated method stub
		return bookDAO.findByTitleLength(length);
	}
	@Override
	@Transactional
	public void updateBook(int bookid, double price) {
		bookDAO.updateBook(bookid, price);
		
	}

	
}

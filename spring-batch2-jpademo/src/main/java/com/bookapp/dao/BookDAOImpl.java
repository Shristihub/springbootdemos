package com.bookapp.dao;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookapp.model.Book;

@Service
public class BookDAOImpl implements BookDAO {

	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	@Transactional
	public void addBook(Book book) {
		entityManager.persist(book);
	}

	@Override
	public Book getById(Integer bookId) {
		Book book = entityManager.find(Book.class,bookId);
		return book;
	}
	
	@Override
	public List<Book> getAll() {
		Query query = entityManager.createQuery("from Book b");
		List<Book> bookList = query.getResultList();
		return bookList;
	}

	@Override
	public List<Book> getByAuthor(String author) {
		Query query = entityManager.createQuery("from Book b where b.author like :auth");
		query.setParameter("auth", author);
		return query.getResultList();
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

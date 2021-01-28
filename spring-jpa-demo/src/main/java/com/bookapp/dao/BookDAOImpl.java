package com.bookapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bookapp.model.Book;

@Component
public class BookDAOImpl implements BookDAO{
	
	@PersistenceContext
	EntityManager entityManager;
	
//	@Override
	@Transactional
	public void addBook(Book book) {
		entityManager.persist(book);
//		
	}

//	@Override
	public Book getById(Integer bookid) {
		Book book = entityManager.find(Book.class,bookid);
		return book;
	}
	
//	@Override
	public List<Book> getAll() {
		Query query = entityManager.createQuery("from Book b");
		List<Book> bookList = query.getResultList();
		return bookList;
	}

//	@Override
	public List<Book> getByAuthor(String author) {
		Query query = entityManager.createQuery("from Book b where b.author like :authorName");
		query.setParameter("author", "authorName");
		List<Book> bookList = query.getResultList();
		return bookList;
	}
}

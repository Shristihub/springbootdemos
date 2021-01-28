package com.bookapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookapp.model.Book;

@Repository
public interface BookDAO extends JpaRepository<Book, Integer> {

	List<Book> findByAuthor(String author);
	List<Book> readByCategory(String category);
	List<Book> findByAuthorAndCategory(String author,String category);
	
	List<Book> findByPriceLessThan(double price);
	
	// using placeholders
//	@Query(value = "FROM Book b WHERE b.author=?1 OR b.category=?2")
//	List<Book> findByAuthCat(String author,String category);
//	
	
	// using parameters
	@Query(value = "FROM Book b WHERE b.author= :auth OR b.category= :category")
	List<Book> findByAuthCat(@Param("auth")String author,@Param("category")String category);
	
	
	@Query(value = "FROM Book b WHERE b.author like %?1%" )
	List<Book> findByAuthStarting(String author);
}

package com.bookapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookapp.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	// derived queries
	List<Book> findByAuthor(String author);
	List<Book> readByCategory(String category);
	List<Book> findByPriceLessThan(double price);
	List<Book> findByAuthorStartingWith(String author);
	
	
	@Query("FROM #{#entityName} b WHERE b.author like %?1%")
	List<Book> findByAuthorPrefix(String author);
	
//	@Query(value = "FROM Book b where b.category=?1 and b.price<?2")
//	List<Book> findByCatPrice(String category, double price);
//	
	
//	@Query(value = "FROM #{#entityName} b where b.category= :category and b.price< :cost")
//	List<Book> findByCatPrice(@Param("category")String category, @Param("cost")double price);
//	
	@Query(name="findByCatPrice")
	List<Book> findByCatPrice(String category, double price);
	
	
	@Query(value = "select * from book where category=?1 or author=?2",nativeQuery=true )
	List<Book> findByCategoryAuthor(String category, String author);
	
	
	
	
}



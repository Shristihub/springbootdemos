package com.bookapp.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookapp.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	// derived queries
	List<Book> findByAuthor(String author, Sort sort);
	List<Book> readByCategory(String category);
	List<Book> findByAuthorAndCategory(String author,String category);
	
	List<Book> findByPriceLessThan(double price);
	
	// using placeholders
//	@Query(value = "FROM Book b WHERE b.author=?1 OR b.category=?2")
//	List<Book> findByAuthCat(String author,String category);
//	
	
	// using parameters
//	@Query(value = "FROM #{#entityName} b WHERE b.author= :auth OR b.category= :category")
//	List<Book> findByAuthCat(@Param("auth")String author,@Param("category")String category);
	
	// native query
	@Query(value = "select * from book where author=?1 and category= ?2", nativeQuery = true)
	List<Book> findByAuthCat(String author,String category);
	
	
	@Query(value = "FROM Book b WHERE b.author like %?1%" )
	List<Book> findByAuthStarting(String author);
	
	@Query(name="findByCat")
	List<Book> findBookWithCat(String category);
	
	@Query(name="findByTitle")
	List<Book> findByTitleLength(int length);
	
	
	@Modifying
	@Query("update Book b set b.price=?2 where b.bookid=?1")
	void updateBook(int bookid,double price);
	
	@Modifying
	@Query("delete from Book b where b.bookid=?1")
	void deleteOneBook(int bookid);
	
	// sorting
	
	@Query("select b, LENGTH(b.title) as title_length  from #{#entityName} b")
	List<Book> findSortedBooks(Sort sort);
	
}

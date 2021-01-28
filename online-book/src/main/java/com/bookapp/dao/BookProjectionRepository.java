package com.bookapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookapp.model.Book;

@Repository
public interface BookProjectionRepository extends JpaRepository<Book,Integer>{

	List<BookInfo> findBy();
}

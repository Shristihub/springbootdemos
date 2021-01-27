package com.bookapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookapp.model.Book;

@Repository
public interface BookDAO extends CrudRepository<Book, Integer> {

}



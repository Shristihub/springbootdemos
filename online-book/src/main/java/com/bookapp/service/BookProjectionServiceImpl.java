package com.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.dao.BookInfo;
import com.bookapp.dao.BookProjectionRepository;

@Service
public class BookProjectionServiceImpl implements BookProjectionService {
	@Autowired
	private BookProjectionRepository bookRepo;

	@Override
	public List<BookInfo> getAllTitles() {
		return bookRepo.findBy();
	}

}

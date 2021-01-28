package com.bookapp.service;

import java.util.List;

import com.bookapp.dao.BookInfo;

public interface BookProjectionService {
	
	List<BookInfo> getAllTitles();
	
}


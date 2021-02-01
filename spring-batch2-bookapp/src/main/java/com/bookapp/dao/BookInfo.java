package com.bookapp.dao;

import org.springframework.beans.factory.annotation.Value;

public interface BookInfo {

	// closed projection
	String getTitle();
	String getAuthor();
	String getCategory();
	
	// open projection
  //	@Value("#{target.title+': '+target.author}")
  //	String getTitleAuthor();

	@Value("#{args[0]+': '+target.title+','+ args[1]+': '+target.author}")
	String getLabeledTitleAuthor(String labelt,String labela);

   default String displayBook() {
	   return String.format("Title:%s, Category:%s", getTitle(),getCategory());
   }

}

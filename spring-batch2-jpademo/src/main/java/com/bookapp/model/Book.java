package com.bookapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Book {

	
	private String title;
	@Id
	@GeneratedValue(generator = "booksequence", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "booksequence",sequenceName = "book_seq",allocationSize = 1 )
	private Integer bookid;
	private String author;
	private String category;
	@Column(name = "cost")
	private double price;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", bookid=" + bookid + ", author=" + author + ", category=" + category
				+ ", price=" + price + "]";
	}
}

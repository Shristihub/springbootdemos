package com.bookapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
//@Table(name = "Bookdetails")
@NoArgsConstructor

@NamedQuery(name="findByCat",
			query= "From Book b where b.category <?1")
@NamedQuery(name="findByTitle",
			query= "From Book b where LENGTH(b.title) <?1")
public class Book {
	private String title;
	private String author;
	private String category;
	@Id
	@GeneratedValue(generator = "bookgenerator", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "bookgenerator",sequenceName = "book_sequence",allocationSize = 1)
	private Integer bookid;
	private double price;
	public Book(String title, String author, String category, double price) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
	}
}





















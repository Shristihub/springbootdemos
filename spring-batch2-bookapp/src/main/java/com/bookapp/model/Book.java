package com.bookapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@NamedQuery(name="findByCatPrice",
            query = "from Book b where b.category=?1 and price<?2")
public class Book {

	private String title;
	@Id
//	@GeneratedValue(generator = "booksequence", strategy = GenerationType.AUTO)
	//@SequenceGenerator(name = "booksequence",sequenceName = "book_seq",allocationSize = 100 )
	private Integer bookid;
	private String author;
	private String category;
	//@Column(name="cost")
	private double price;
	public Book(String title, String author, String category, double price) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
	}

	


}

package com.spring.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Book {
	
	private int id;
	private String bookName;
	private String bookAuthor;
	private String bookNumber;
	
	
	public Book(String bookName, String bookAuthor, String bookNumber) {
		super();
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookNumber = bookNumber;
	}
	
	

	
}

package com.SpringBootRestProject.Models;

import java.io.File;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import lombok.Data;


@Data
@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;
	private String bookName;
	private String genre;
	
	@ManyToMany
	private List<Author> authors;
	@Lob
	@Column(columnDefinition = "LONGBLOB",length=10000000)
	private List<byte[]> bookimages;

}

package com.cg.bfa.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="BookTable")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	
	@NotEmpty(message = "Enter your name")
	@Column(name="Author_Name")
	private String authorName;
	
	@NotEmpty(message = "Enter book name")
	@Column(name="Book_Name")
	private String bookName;
	

	public Book() {
		super();
	
	}
	

	public Book(int bookId, @NotEmpty(message = "Enter your name") String authorName,
			@NotEmpty(message = "Enter book name") String bookName) {
		super();
		this.bookId = bookId;
		this.authorName = authorName;
		this.bookName = bookName;
	}


	public int getBookId() {
		return bookId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", authorName=" + authorName + ", bookName=" + bookName + "]";
	}
	
}

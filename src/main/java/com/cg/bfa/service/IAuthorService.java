package com.cg.bfa.service;

import com.cg.bfa.entities.Book;
import com.cg.bfa.exception.BookAlreadyExistsException;

public interface IAuthorService {
	
	public Book addBook(Book book) throws BookAlreadyExistsException;
	

}

package com.cg.bfa.service;

import java.util.List;

import com.cg.bfa.entities.Book;
import com.cg.bfa.exception.BookNotFoundException;

public interface IReaderService {
	
	public Book findBookById(int bId)  throws BookNotFoundException;
	public List<Book> findbyBookName(String bName)  throws BookNotFoundException;
	public List<Book> findbyAuthorName(String aName)  throws BookNotFoundException;

}

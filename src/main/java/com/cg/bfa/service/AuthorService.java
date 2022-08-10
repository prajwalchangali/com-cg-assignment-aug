package com.cg.bfa.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bfa.entities.Book;
//import com.cg.bfa.exception.BookAlreadyExists;
import com.cg.bfa.exception.BookAlreadyExistsException;
import com.cg.bfa.repository.IBookRepository;



@Service
public class AuthorService implements IAuthorService {
	
	
	private static final Logger LOG = LoggerFactory.getLogger(AuthorService.class);
	
	@Autowired
	private IBookRepository iBookRepository;

	@Override
	public Book addBook(Book book) throws BookAlreadyExistsException {
		LOG.info("Service addBook");
		if(iBookRepository.findBybookName(book.getBookName()) == null) {
			LOG.info("New book added");
			return iBookRepository.save(book);
		}
		else {
			LOG.info("Book already exists");
			throw new BookAlreadyExistsException("Book already exists");
		}
	}
	
	

}

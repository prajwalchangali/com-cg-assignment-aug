package com.cg.bfa.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import com.cg.bfa.entities.Book;
import com.cg.bfa.exception.BookNotFoundException;
import com.cg.bfa.service.ReaderService;



@RestController
@RequestMapping("/Reader")
@CrossOrigin(origins = "*")
public class ReaderController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ReaderController.class);
	
	
	@Autowired
	private ReaderService iReaderService;
	
	@GetMapping("/getbyid/{bookId}")
	public ResponseEntity<Book> getBookById(@Valid @PathVariable(name="bookId") int bId) throws BookNotFoundException{
		LOG.info("getbookbyid");
		Book book = iReaderService.findBookById(bId);
		LOG.info(book.toString());
		HttpHeaders headers = new HttpHeaders();
  		headers.add("message", "Book available");
  		LOG.info(headers.toString());
		ResponseEntity<Book> response = new ResponseEntity<Book>(book, headers, HttpStatus.OK);
		return response;	
	}
	
	@GetMapping("/getbybookname/{bookName}")
	public ResponseEntity<List<Book>> findbyBookName(@Valid @PathVariable(name="bookName") String bname) throws BookNotFoundException{
		LOG.info("getbookbybookname");
		List<Book> book = iReaderService.findbyBookName(bname);
		LOG.info(book.toString());
		HttpHeaders headers = new HttpHeaders();
  		headers.add("message", "Book available");
  		LOG.info(headers.toString());
		ResponseEntity<List<Book>> response = new ResponseEntity<List<Book>>( book,headers, HttpStatus.OK);
		return response;	
	}

	
	@GetMapping("/getauthorname/{authorName}")
	public ResponseEntity<List<Book>> findbyAuthorName(@Valid @PathVariable(name="authorName") String aname) throws BookNotFoundException{
		LOG.info("getbookbyauthorname");
		List<Book> book = iReaderService.findbyAuthorName(aname);
		LOG.info(book.toString());
		HttpHeaders headers = new HttpHeaders();
  		headers.add("message", "Book available");
  		LOG.info(headers.toString());
		ResponseEntity<List<Book>> response = new ResponseEntity<List<Book>>( book,headers, HttpStatus.OK);
		return response;	
	}

}

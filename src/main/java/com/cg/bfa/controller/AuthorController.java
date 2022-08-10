package com.cg.bfa.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bfa.entities.Book;
import com.cg.bfa.exception.BookAlreadyExistsException;
import com.cg.bfa.service.AuthorService;


@RestController
@RequestMapping("/Author")
@CrossOrigin(origins = "*")
public class AuthorController {
	
	private static final Logger LOG = LoggerFactory.getLogger(AuthorController.class);
	
	@Autowired
	private AuthorService iAuthorService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) throws BookAlreadyExistsException{
		LOG.info("Controller addBook");
		Book bk = iAuthorService.addBook(book);
		HttpHeaders headers = new HttpHeaders();
  		headers.add("message", "Book added");
		ResponseEntity<Book> response = new ResponseEntity<Book>(bk, headers, HttpStatus.OK);
		return response;
	}

}

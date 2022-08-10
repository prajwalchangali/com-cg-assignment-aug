package com.cg.bfa.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.cg.bfa.entities.Book;
import com.cg.bfa.exception.BookNotFoundException;
//import com.cg.bfa.exception.NoBookFoundException;
import com.cg.bfa.repository.IBookRepository;

@Service
public class ReaderService implements IReaderService {
	
	
	private static final Logger LOG = LoggerFactory.getLogger(ReaderService.class);
	
	@Autowired
	private IBookRepository iBookRepository;

	@Override
	public Book findBookById(int bId) throws BookNotFoundException {
		LOG.info("findBookById");
		Optional<Book> bookOpt = iBookRepository.findById(bId);
		if (bookOpt.isPresent()) {
			LOG.info("book is available.");
			return bookOpt.get();
		}else {
			LOG.info("book unavailable.");
			throw new BookNotFoundException ("book with id "+ bId + "  is unavailable.");
		}
		
	}

	@Override
	public List<Book> findbyBookName(String bName) throws BookNotFoundException{
		LOG.info("findBookByName");
		if(iBookRepository.findBybookName(bName)!=null) {
			LOG.info("book available");
			ArrayList<Book> bk= new ArrayList<>();
		Book bookOpt = iBookRepository.findBybookName(bName);
		bk.add(bookOpt);
		return bk;
//		List<Book> bookOpt = iBookRepository.findAll();
//		return bookOpt;	
		}else {
			LOG.info("book unavailable.");
			throw new BookNotFoundException (" this book is unavailable.");
		}
	}

	@Override
	public List<Book> findbyAuthorName(String aName)  throws BookNotFoundException {
		LOG.info("find bookby aname");
		ArrayList<Book> bk= new ArrayList<>();
				if(iBookRepository.findByauthorName(aName)!=null) {
					LOG.info("book available");
				Book bookOpt = iBookRepository.findByauthorName(aName);
				bk.add(bookOpt);
				return bk;
				}else {
			LOG.info("book unavailable.");
			throw new BookNotFoundException (" this book is unavailable.");
		}
	}
	
//	@Override
//	public List<Book> findbyAuthorName(String aName)  throws BookNotFoundException {
//		LOG.info("find bookby aname");
//		ArrayList<Book> bk= new ArrayList<>();
//		
//	
//		if(iBookRepository.findAll()!=null) {
//			LOG.info("book available");
//			while(iBookRepository.findAll()!=null) {
//				if(iBookRepository.findByauthorName(aName)!=null) {
//				Book bookOpt = iBookRepository.findByauthorName(aName);
//				bk.add(bookOpt);
//				}
//			}
//			return bk;
//		}else {
//			LOG.info("book unavailable.");
//			throw new BookNotFoundException (" this book is unavailable.");
//		}
//	}
	
}

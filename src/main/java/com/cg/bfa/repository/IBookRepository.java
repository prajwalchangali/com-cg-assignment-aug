package com.cg.bfa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bfa.entities.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {

//	boolean exists(String aName);

//	boolean existsbyname(String bookName);
	
	public abstract Book findBybookName(String bookName);
	public abstract Book findByauthorName(String authorName);
	
	

}

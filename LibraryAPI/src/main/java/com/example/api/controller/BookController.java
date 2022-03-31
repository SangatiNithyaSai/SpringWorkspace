package com.example.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.BookClass.Book;
import com.example.api.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService bookservice;

	@GetMapping("/library")
	private List<Book> getAllBooks(){
		return bookservice.getAllBooks();
	}
	
	@GetMapping("/library/{id}")
	private Book getBookById(@PathVariable("id") int id) {
		 return bookservice.getBookById(id);
	}
	
	@DeleteMapping("/library/{id}")
	private void deleteBookById(@PathVariable int id){
		bookservice.delete(id);
	}
	
	
	@PostMapping("/library")
	private int saveBook(@RequestBody Book book) {
		bookservice.saveOrUpdate(book);
		return book.getId();
	}
	@GetMapping("/library/check/{id}")
	private boolean checkIfExists(@PathVariable int id) {
		return bookservice.checkExists(id);
	}
	
	
}


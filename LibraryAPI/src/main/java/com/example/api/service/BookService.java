package com.example.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.BookClass.Book;
import com.example.api.repoitory.BookRepository;
@Service
public class BookService {
    
	@Autowired
	BookRepository bookrepo;
	
	public List<Book> getAllBooks(){
		List<Book> books=new ArrayList<>();
		bookrepo.findAll().forEach(book->books.add(book));
		return books;
	}
	public Book  getBookById(int id) {
	return	bookrepo.findById(id).get();
	}
	public void delete(int id) {
		bookrepo.deleteById(id);
	}
	public void saveOrUpdate(Book book) {
		bookrepo.save(book);
	}
	public boolean checkExists(int id) {
		return bookrepo.existsById(id);
	}
}

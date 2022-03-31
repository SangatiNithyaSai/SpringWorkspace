package com.example.api.repoitory;

import org.springframework.data.repository.CrudRepository;

import com.example.api.BookClass.Book;

public interface  BookRepository extends CrudRepository<Book,Integer>  {

}

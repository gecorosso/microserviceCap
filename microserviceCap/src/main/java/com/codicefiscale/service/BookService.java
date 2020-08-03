package com.codicefiscale.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.codicefiscale.entity.Book;

public interface BookService {
	//Book saveBook(Book book) throws EntityNotFoundException;
    List<Book> findByIdName(String name) throws EntityNotFoundException; 
    List<Book> findByIdAuthor(String autore) throws EntityNotFoundException;
}

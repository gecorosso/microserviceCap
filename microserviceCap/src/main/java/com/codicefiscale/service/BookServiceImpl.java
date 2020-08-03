package com.codicefiscale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codicefiscale.dao.BookRepositoryDao;
import com.codicefiscale.entity.Book;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepositoryDao bookRepositoryDao;
	
	
	//@Override
	//public Book saveBook(Book book) throws EntityNotFoundException {
	//	return bookRepositoryDao.save(book);
	//}


	@Override
	public List<Book> findByIdName(String name) {
		return bookRepositoryDao.findByIdName(name);
	}


	@Override
	public List<Book> findByIdAuthor(String author) {
		return bookRepositoryDao.findByIdAuthor(author);
	}
	
	

}

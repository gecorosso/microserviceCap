package com.codicefiscale.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codicefiscale.entity.Book;
import com.codicefiscale.entity.BookId;

@Repository
public interface BookRepositoryDao extends JpaRepository<Book, BookId> {
	List<Book> findByIdName(String name);
	List<Book> findByIdAuthor(String author);
}

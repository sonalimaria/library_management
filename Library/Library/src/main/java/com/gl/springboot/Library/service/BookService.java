package com.gl.springboot.Library.service;

import java.util.List;

import com.gl.springboot.Library.entity.Book;

public interface BookService {

	void save(Book book);

	List<Book> findAll();

	Book findById(int id);

	void deleteById(int id);
}

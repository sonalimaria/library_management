package com.gl.springboot.Library.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.springboot.Library.entity.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer>
{

	
}

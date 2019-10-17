package com.livedemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.livedemo.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
}
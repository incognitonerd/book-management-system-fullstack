package com.livedemo.dao;

import java.util.Optional;

import com.livedemo.model.Book;

public interface BookDAO {
	Optional<Integer> saveNewBook(Book newBook);

	Optional<Book> getBookById(int bookId);

	Optional<Iterable<Book>> getAllBooks();

	void updateBookById(int bookId, Book updatedBook);

	void deleteBookById(int bookId);
}

package com.livedemo.dao;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.livedemo.controller.BookController;
import com.livedemo.model.Book;
import com.livedemo.repository.BookRepository;

@Component
public class BookDAOImp implements BookDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(BookDAOImp.class);

	@Autowired
	private BookRepository bookRepo;

	@Override
	public Optional<Integer> saveNewBook(Book newBook) {
		bookRepo.save(newBook);
		return Optional.ofNullable(newBook.getId());
	}

	@Override
	public Optional<Book> getBookById(int bookId) {
		return bookRepo.findById(bookId);
	}

	@Override
	public Optional<Iterable<Book>> getAllBooks() {
		return Optional.ofNullable(bookRepo.findAll());
	}

	@Override
	public void updateBookById(int bookId, Book updatedBook) {
		Optional<Book> oldBook = bookRepo.findById(bookId);
		if (oldBook.isPresent()) {
			oldBook.get().setAuthor(updatedBook.getAuthor());
			oldBook.get().setTitle(updatedBook.getTitle());
			oldBook.get().setPages(updatedBook.getPages());
			bookRepo.save(oldBook.get());
		}
	}

	@Override
	public void deleteBookById(int bookId) {
		Optional<Book> book = bookRepo.findById(bookId);
		if (book.isPresent()) {
			bookRepo.deleteById(bookId);
		}
	}
}

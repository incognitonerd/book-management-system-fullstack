package com.livedemo.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.livedemo.dao.BookDAO;
import com.livedemo.model.Book;

@Service
public class BookServiceImp implements BookService {
	private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImp.class);

	@Autowired
	private BookDAO bookDao;

	@Override
	@Transactional
	public Optional<Integer> saveNewBook(Book newBook) {
		bookDao.saveNewBook(newBook);
		return Optional.ofNullable(newBook.getId());
	}

	@Override
	@Transactional
	public Optional<Book> getBookById(int bookId) {
		return bookDao.getBookById(bookId);
	}

	@Override
	@Transactional
	public Optional<Iterable<Book>> getAllBooks() {
		return bookDao.getAllBooks();
	}

	@Override
	@Transactional
	public void updateBookById(int bookId, Book updatedBook) {
		bookDao.updateBookById(bookId, updatedBook);
	}

	@Override
	@Transactional
	public void deleteBookById(int bookId) {
		bookDao.deleteBookById(bookId);
	}
}

package com.livedemo.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livedemo.model.Book;
import com.livedemo.service.BookService;

@RestController
@RequestMapping("/books/api")
public class BookController {
	private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookService bookService;

	@GetMapping("/getAllBooks")
	public ResponseEntity<Optional<Iterable<Book>>> getAllBooks() {
		return ResponseEntity.ok().body(bookService.getAllBooks());
	}

	/* this needs some type of validation of the request body */
	@PostMapping("/saveNewBook")
	public ResponseEntity<String> saveNewBook(@RequestBody Book newBook) {
		Optional<Integer> bookId = bookService.saveNewBook(newBook);
		if (bookId.isPresent())
			return ResponseEntity.ok().body("New Book Saved With Id - " + bookId.get());
		return ResponseEntity.ok().body("New Book Failed To Save - " + bookId.get());
	}

	@GetMapping("/getBookById/{bookId}")
	public ResponseEntity<String> getBookById(@PathVariable int bookId) {
		Optional<Book> book = bookService.getBookById(bookId);
		if (book.isPresent())
			return ResponseEntity.ok().body(book.get().toString());
		return ResponseEntity.ok().body("Book Id - " + bookId + " Not Found");
	}

	/* this needs some type of validation for book not found */
	@PutMapping("/updateBookById/{bookId}")
	public ResponseEntity<String> updateBookById(@PathVariable int bookId, @RequestBody Book updatedBook) {
		bookService.updateBookById(bookId, updatedBook);
		return ResponseEntity.ok().body("Book Id - " + bookId + " Updated");
	}

	/* this needs some type of validation for book not found */
	@DeleteMapping("/deleteBookById/{bookId}")
	public ResponseEntity<String> deleteBookById(@PathVariable int bookId) {
		bookService.deleteBookById(bookId);
		return ResponseEntity.ok().body("Book Id - " + bookId + " Deleted");
	}
}

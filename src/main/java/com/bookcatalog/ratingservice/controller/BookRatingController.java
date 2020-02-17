package com.bookcatalog.ratingservice.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookcatalog.ratingservice.customexception.ArgumentNotValidException;
import com.bookcatalog.ratingservice.customexception.RecordNotFoundException;
import com.bookcatalog.ratingservice.model.BookRating;
import com.bookcatalog.ratingservice.service.BookRatingServiceImpl;

@RestController
public class BookRatingController {

	@Autowired
	BookRatingServiceImpl bookRatingServiceImpl;

	@GetMapping(value = "api/bookcatalog", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<BookRating>> getBookRatingeDetails() {
		Collection<BookRating> listBookRating = bookRatingServiceImpl.getBookRatingDetails();
		if (listBookRating.isEmpty()) {
			throw new RecordNotFoundException("NO RECORDS FOUND IN DATABASE");
		}
		return new ResponseEntity<Collection<BookRating>>(listBookRating, HttpStatus.OK);
	}

	@GetMapping(value = "api/bookcatalog/{userId}/{bookId}/rating", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookRating> getBookRatingDetailById(@PathVariable("userId") String userId,
			@Valid @PathVariable("bookId") int bookId) {
		BookRating bookRating = bookRatingServiceImpl.getBookRatingDetailById(userId, bookId);
		if (bookRating == null) {
			throw new RecordNotFoundException("Record Not Found for given User Id and Book ID");
		}

		return new ResponseEntity<BookRating>(bookRating, HttpStatus.FOUND);
	}

	@PutMapping(value = "api/bookcatalog/{userId}/{bookId}/rating", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookRating> updateBookRatingeDetails(@RequestBody BookRating bookRating) {
		BookRating bookRating1 = bookRatingServiceImpl.updateBookRatingDetails(bookRating);
		if (bookRating1 == null) {
			throw new ArgumentNotValidException("Parameters provided are not valid");
		}
		return new ResponseEntity<BookRating>(bookRating1, HttpStatus.ACCEPTED);
	}

	@PostMapping(value = "api/bookcatalog/{userId}/{bookId}/rating", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookRating> addBookRating(@PathVariable("userId") String userId,
			@PathVariable("bookId") int bookId, @RequestBody BookRating bookRating) {
		BookRating bookRating1 = bookRatingServiceImpl.addBookRating(bookRating);
		if (bookRating1 == null) {
			throw new ArgumentNotValidException("Paramets provided are not valid");
		}
		return new ResponseEntity<BookRating>(bookRating1, HttpStatus.CREATED);
	}

	
	@DeleteMapping(value = "api/bookcatalog/{userId}/{bookId}/rating", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteBookRating(@PathVariable("userId") String userId,@PathVariable("bookId") int bookId) {
		int deleteID = bookRatingServiceImpl.deleteBookRatingDetails(userId,bookId);

		if (deleteID == -1) {
			throw new RecordNotFoundException("Record Not Found for User Id and Book ID to be deleted");
		}

		return new ResponseEntity<String>("Book deleted successfully with bookID: " + bookId, HttpStatus.OK);
	}
}

package com.bookcatalog.ratingservice.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookcatalog.ratingservice.dao.BookRatingDAO;
import com.bookcatalog.ratingservice.entity.BookRatingEntity;
import com.bookcatalog.ratingservice.entity.BookUserIdEntity;
import com.bookcatalog.ratingservice.model.BookRating;
import com.google.gson.Gson;

@Service
public class BookRatingServiceImpl {

	@Autowired
	private BookRatingDAO bookRatingDAO;

	
	public Collection<BookRating> getBookRatingDetails() {
		Collection<BookRatingEntity> collec = bookRatingDAO.findAll();
		List<BookRating> listBookRating = new ArrayList<BookRating>();
		for (BookRatingEntity bookRatingEntity : collec) {
			BookRating bookRating = new BookRating();
			Gson gson = new Gson();
			bookRating = gson.fromJson(gson.toJson(bookRatingEntity), BookRating.class);
			listBookRating.add(bookRating);
		}
		return listBookRating;
	}

	public BookRating getBookRatingDetailById(String userId, int bookId) {
		BookUserIdEntity bookUserIdEntity = new BookUserIdEntity();
		bookUserIdEntity.setBookId(bookId);
		bookUserIdEntity.setUserId(userId);
		Optional<BookRatingEntity> bookRatingEntity = bookRatingDAO.findByBookUserId_BookId(bookId);
		BookRating bookRating = new BookRating();
		Gson gson = new Gson();
		if (bookRatingEntity.isPresent()) {
			BookRatingEntity bookRatingEnt = bookRatingEntity.get();
			bookRating = gson.fromJson(gson.toJson(bookRatingEnt), BookRating.class);
			return bookRating;
		}

		return null;
}

	
	public BookRating updateBookRatingDetails(BookRating bookRating) {
		BookRatingEntity bookRatingEntity = new BookRatingEntity();
		Gson gson = new Gson();
		bookRatingEntity = gson.fromJson(gson.toJson(bookRating), BookRatingEntity.class);
		Optional<BookRatingEntity> bookrateentity = bookRatingDAO.findById(bookRatingEntity.getBookUserId());
		if (bookrateentity.isPresent()) {
			BookRatingEntity bookrateentity1 = bookRatingDAO.save(bookRatingEntity);
			return gson.fromJson(gson.toJson(bookrateentity1), BookRating.class);
		}
		return null;
	}
	
	

	/*public void deleteBookRatingDetails(int bookId) {
		BookUserIdEntity bookUserIdEntity = new BookUserIdEntity();
		bookUserIdEntity.setBookId(bookId);
		bookRatingDAO.deleteByBookUserId_BookId(bookId);

	}*/
	
	public int deleteBookRatingDetails(int bookId) {
		BookUserIdEntity bookUserIdEntity = new BookUserIdEntity();
		bookUserIdEntity.setBookId(bookId);
		Optional<BookRatingEntity> bookRatingEntity = bookRatingDAO.findByBookUserId_BookId(bookId);
		if (bookRatingEntity.isPresent()) {
		bookRatingDAO.deleteByBookUserId_BookId(bookId);
		return bookId;
		}
		  
		return -1;
	}   

	/*public int addBookRating(BookRating bookRating) {
		BookRatingEntity bookRatingEntity = new BookRatingEntity();
		Gson gson = new Gson();
		bookRatingEntity = gson.fromJson(gson.toJson(bookRating), BookRatingEntity.class);
		BookRatingEntity bookrateentity = bookRatingDAO.save(bookRatingEntity);
		return bookrateentity.getRating();
	}*/
	
	public BookRating addBookRating(BookRating bookRating) {
		BookRatingEntity bookRatingEntity = new BookRatingEntity();
		Gson gson = new Gson();
		bookRatingEntity = gson.fromJson(gson.toJson(bookRating), BookRatingEntity.class);
		BookRatingEntity bookrateentity = bookRatingDAO.save(bookRatingEntity);
		if(bookrateentity !=null) {
		return gson.fromJson(gson.toJson(bookrateentity), BookRating.class);}
		return null;
	}

}

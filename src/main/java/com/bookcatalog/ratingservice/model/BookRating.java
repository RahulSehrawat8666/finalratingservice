package com.bookcatalog.ratingservice.model;

import java.io.Serializable;

public class BookRating implements Cloneable, Serializable {

	private static final long serialVersionUID = 1L;
	private BookUserId bookUserId;
	private int rating;

	public BookRating() {
		super();
	}

	public BookRating(BookUserId bookUserId, int rating) {
		super();
		this.bookUserId = bookUserId;
		this.rating = rating;
	}

	public BookUserId getBookUserId() {
		return bookUserId;
	}

	public void setBookUserId(BookUserId bookUserId) {
		this.bookUserId = bookUserId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "BookRating [bookUserId=" + bookUserId + ", rating=" + rating + "]";
	}

}
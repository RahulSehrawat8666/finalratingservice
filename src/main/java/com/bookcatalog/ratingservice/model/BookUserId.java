package com.bookcatalog.ratingservice.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class BookUserId implements Serializable {

	private static final long serialVersionUID = 1L;
	@NotEmpty(message = "BookId is required Field")
	private int bookId;
	@NotEmpty(message = "UserId is required Field")
	private String userId;

	public BookUserId() {
		super();
	}

	public BookUserId(int bookId, String userId) {
		super();
		this.bookId = bookId;
		this.userId = userId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}

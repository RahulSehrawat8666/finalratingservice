package com.bookcatalog.ratingservice.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class BookUserIdEntity implements Cloneable, Serializable {

	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	private String userId;

	public BookUserIdEntity() {
		super();
	}

	public BookUserIdEntity(int bookId, String userId) {
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

	@Override
	public String toString() {
		return "BookUserId [bookId=" + bookId + ", userId=" + userId + "]";
	}

	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}

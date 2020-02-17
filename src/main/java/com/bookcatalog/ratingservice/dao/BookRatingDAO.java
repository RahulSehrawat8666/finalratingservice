package com.bookcatalog.ratingservice.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bookcatalog.ratingservice.entity.BookRatingEntity;
import com.bookcatalog.ratingservice.entity.BookUserIdEntity;

@Transactional
public interface BookRatingDAO extends JpaRepository<BookRatingEntity, BookUserIdEntity> {

	Optional<BookRatingEntity> findByBookUserId_BookId(int bookId);

	Optional<BookRatingEntity> deleteByBookUserId_BookId(int bookId);

	Optional<BookRatingEntity> findByBookUserId_UserIdAndBookUserId_BookId(String userId, int bookId);

	void deleteByBookUserId_UserIdAndBookUserId_BookId(String userId, int bookId);

}

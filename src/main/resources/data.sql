DROP TABLE IF EXISTS BOOK_RATING;
  
CREATE TABLE BOOK_RATING (
  book_id INT NOT NULL,
  user_id VARCHAR(250) NOT NULL,
  rating INT NOT NULL,
  PRIMARY KEY(book_id, user_id )
);

INSERT INTO BOOK_RATING (book_id,user_id, rating) VALUES
  (1,'U01', 1),
  (2,'U02', 5),
  (3,'U03', 3);

CREATE TABLE book
(
    id             BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(20),
    publication_date           DATE,
    number_of_copies       INTEGER,
    genre_id VARCHAR(20),
    publisher_id BIGINT,
    cover_id BIGINT,
    CONSTRAINT fk_book_publisher FOREIGN KEY (publisher_id)
        REFERENCES publisher(id),
    CONSTRAINT fk_book_cover FOREIGN KEY (cover_id)
        REFERENCES cover (id)
);
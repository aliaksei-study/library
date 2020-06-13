CREATE TABLE book
(
    id             BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(20),
    publication_date           DATE,
    number_of_copies       INTEGER,
    genre_id VARCHAR(20),
    publisher_id BIGINT,
    reader_id BIGINT,
    book_keeper_id BIGINT,
    CONSTRAINT fk_book_publisher FOREIGN KEY (publisher_id)
        REFERENCES publisher(id),
    CONSTRAINT fk_book_reader FOREIGN KEY (reader_id)
        REFERENCES reader(id),
    CONSTRAINT fk_book_book_keeper FOREIGN KEY (book_keeper_id)
        REFERENCES book_keeper(id)
);
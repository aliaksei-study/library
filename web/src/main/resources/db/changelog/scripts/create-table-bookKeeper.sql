CREATE TABLE book_keeper
(
    id             BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    date_of_issue DATE,
    return_date           DATE,
    book_id BIGINT,
    reader_id BIGINT,
    CONSTRAINT fk_book_keeper_book FOREIGN KEY (book_id)
        REFERENCES book (id),
    CONSTRAINT fk_book_keeper_reader FOREIGN KEY (reader_id)
        REFERENCES reader (id)
);
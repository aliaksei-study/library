CREATE TABLE author_book (
    book_id BIGINT NOT NULL,
    author_id BIGINT NOT NULL,
    CONSTRAINT fk_author_book_author FOREIGN KEY (author_id)
        REFERENCES author (id),
    CONSTRAINT  fk_author_book_book FOREIGN KEY (book_id)
        REFERENCES book (id)
);
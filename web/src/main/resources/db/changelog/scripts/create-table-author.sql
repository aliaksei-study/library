CREATE TABLE author (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    note VARCHAR(100),
    CONSTRAINT fk_author_human FOREIGN KEY (id)
        REFERENCES human(id)
);
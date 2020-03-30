CREATE TABLE reader (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(40),
    phone VARCHAR(20),
    photo_id BIGINT,
    CONSTRAINT fk_reader_photo FOREIGN KEY (photo_id)
        REFERENCES photo (id)
);
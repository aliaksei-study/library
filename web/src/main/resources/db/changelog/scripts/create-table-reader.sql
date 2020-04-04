CREATE TABLE reader (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    phone VARCHAR(20),
    photo_id BIGINT,
    usr_id BIGINT,
    CONSTRAINT fk_reader_photo FOREIGN KEY (photo_id)
        REFERENCES photo (id),
    CONSTRAINT fk_reader_usr FOREIGN KEY (usr_id)
        REFERENCES usr(id),
    CONSTRAINT fk_reader_human FOREIGN KEY (id)
        REFERENCES human(id)
);
CREATE TABLE cover
(
    id             BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    date_of_upload DATE,
    note           VARCHAR(100),
    photo_id       BIGINT,
    CONSTRAINT fk_cover_photo FOREIGN KEY (photo_id)
        REFERENCES photo (id)
);
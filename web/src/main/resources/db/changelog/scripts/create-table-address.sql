CREATE TABLE address (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    region VARCHAR(30),
    city VARCHAR(30),
    street VARCHAR(30),
    number_of_street SMALLINT
);
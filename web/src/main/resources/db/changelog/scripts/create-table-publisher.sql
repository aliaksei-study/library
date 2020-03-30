CREATE TABLE publisher (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    country_id VARCHAR(20),
    postcode INT,
    email VARCHAR(40),
    address_id BIGINT,
    CONSTRAINT fk_publisher_address FOREIGN KEY (address_id)
        REFERENCES address (id)
);
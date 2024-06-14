CREATE TABLE rental (
    id INT AUTO_INCREMENT PRIMARY KEY,
    rent_date DATE NOT NULL
);

CREATE TABLE rentaldetail (
    id INT AUTO_INCREMENT PRIMARY KEY,
    rental_day DATE NOT NULL,
    number_day INT NOT NULL,
    return_day DATE NOT NULL,
    amount INT NOT NULL,
    book_id INT NOT NULL,
    rental_id INT NOT NULL,
    FOREIGN KEY (rental_id) REFERENCES rental(id)
);
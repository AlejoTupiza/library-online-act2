CREATE DATABASE LibraryDB;
-- Crear tabla author
CREATE TABLE author (
    id SERIAL PRIMARY KEY,
    name VARCHAR(64) NOT NULL,
    last_name VARCHAR(64) NOT NULL
);

-- Crear tabla gender
CREATE TABLE gender (
    id SERIAL PRIMARY KEY,
    name VARCHAR(32) NOT NULL
);

-- Crear tabla book
CREATE TABLE book (
    id SERIAL PRIMARY KEY,
    isbn BIGINT NOT NULL,
    title VARCHAR(128) NOT NULL,
    author_id INT NOT NULL,
    gender_id INT NOT NULL,
    img_book VARCHAR(255),
    year_publication INT,
    stock INT,
    synopsis TEXT,
    criticism TEXT,
    FOREIGN KEY (author_id) REFERENCES author(id),
    FOREIGN KEY (gender_id) REFERENCES gender(id)
);
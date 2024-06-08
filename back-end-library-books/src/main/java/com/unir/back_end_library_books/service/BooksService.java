package com.unir.back_end_library_books.service;

import com.unir.back_end_library_books.model.pojo.Book;

import java.util.List;

public interface BooksService {

    List<Book> getBooks(String title, String isbn, String author, String gender, Integer yearPublication, Integer stock, String synopsis, String criticism);

    Book getBook(String id);

    Boolean removeBook(String id);

    Book createBook(Book book);
}

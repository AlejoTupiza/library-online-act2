package com.unir.back_end_library_books.service;

import com.unir.back_end_library_books.model.pojo.Book;
import com.unir.back_end_library_books.model.pojo.BookDto;
import com.unir.back_end_library_books.model.request.CreateBookRequest;

import java.util.List;

public interface BooksService {

    List<Book> getBooks(Long isbn, String title, Integer yearPublication, Integer stock, String imgBook, String synopsis, String criticism, String author, String gender);

    Book getBook(String id);

    Boolean removeBook(String id);

    Book createBook(CreateBookRequest request);

    Book updateBook(String id , String updateRequest);

    Book updateBook(String id, BookDto updateRequest);
}

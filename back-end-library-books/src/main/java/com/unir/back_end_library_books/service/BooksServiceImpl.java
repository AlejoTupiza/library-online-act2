package com.unir.back_end_library_books.service;

import com.unir.back_end_library_books.data.BookRepository;
import com.unir.back_end_library_books.model.pojo.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Slf4j
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BookRepository repository;

    //@Autowired
    //private ObjectMapper objectMapper;

    @Override
    public List<Book> getBooks(String title, String isbn, String author, String gender, Integer year_publication, Integer stock, String synopsis, String criticism) {
        if (StringUtils.hasLength(title) || StringUtils.hasLength(isbn) || StringUtils.hasLength(author) ||
                StringUtils.hasLength(gender) || year_publication == null || stock == null || synopsis == null || criticism == null) {
            return repository.search(title, isbn);
        }

        List<Book> books = repository.getBooks();
        return books.isEmpty() ? null : books;
    }

    @Override
    public Book getBook(String id) {
        return null;
    }

    @Override
    public Boolean removeBook(String id) {
        return null;
    }

    @Override
    public Book createBook(Book book) {
        return null;
    }
}

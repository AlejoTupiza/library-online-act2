package com.unir.back_end_library_books.controller;

import com.unir.back_end_library_books.model.pojo.Book;
import com.unir.back_end_library_books.service.BooksService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BooksController {

    private final BooksService service;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(
            @RequestHeader Map<String, String> headers,
            @RequestParam(required = false) Long isbn,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Integer yearPublication,
            @RequestParam(required = false) Integer stock,
            @RequestParam(required = false) String imgBook,
            @RequestParam(required = false) String synopsis,
            @RequestParam(required = false) String criticism,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String gender) {
        log.info("headers: {}", headers);
        List<Book> books = service.getBooks(isbn, title, yearPublication, stock, imgBook, synopsis, criticism, author, gender);

        if (books != null) {
            return ResponseEntity.ok(books);
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }
}

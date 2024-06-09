package com.unir.back_end_library_books.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import com.unir.back_end_library_books.data.BookRepository;
import com.unir.back_end_library_books.model.pojo.Book;
import com.unir.back_end_library_books.model.pojo.BookDto;
import com.unir.back_end_library_books.model.request.CreateBookRequest;
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

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<Book> getBooks(Long isbn, String title, Integer yearPublication, Integer stock, String imgBook,
                               String synopsis, String criticism, String author, String gender) {
        if (isbn !=null || StringUtils.hasLength(title) || yearPublication != null || stock != null ||
                StringUtils.hasLength(imgBook) || StringUtils.hasLength(synopsis) || StringUtils.hasLength(criticism) ||
                StringUtils.hasLength(author) || StringUtils.hasLength(gender)) {
            return repository.search(String.valueOf(isbn), title, yearPublication, stock, synopsis, criticism, author, gender);
        }

        List<Book> books = repository.getBooks();
        return books.isEmpty() ? null : books;
    }

    @Override
    public Book getBook(String id) {return repository.getById(Long.valueOf(id));}

    @Override
    public Boolean removeBook(String id) {
        Book book = repository.getById(Long.valueOf(id));

        if (book != null) {
            repository.delete(book);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    public Book createBook(CreateBookRequest request) {
        if (request != null && request.getIsbn() != null &&
                StringUtils.hasLength(request.getTitle()) &&
                request.getYearPublication() != null &&
                request.getStock() != null &&
                StringUtils.hasLength(request.getImgBook()) &&
                StringUtils.hasLength(request.getSynopsis()) &&
                StringUtils.hasLength(request.getCriticism()) &&
                request.getAuthor() != null &&
                request.getGender() != null) {
            Book book = Book.builder()
                    .isbn(request.getIsbn())
                    .title(request.getTitle())
                    .yearPublication(request.getYearPublication())
                    .stock(request.getStock())
                    .imgBook(request.getImgBook())
                    .synopsis(request.getSynopsis())
                    .criticism(request.getCriticism())
                    .author(request.getAuthor())
                    .gender(request.getGender())
                    .build();
            return repository.save(book);
        } else {
            return null;
        }
    }

    @Override
    public Book updateBook(String id, String request) {
        Book book = repository.getById(Long.valueOf(id));
        if (book != null) {
            try {
                JsonMergePatch jsonMergePatch = JsonMergePatch.fromJson(objectMapper.readTree(request));
                JsonNode target = jsonMergePatch.apply(objectMapper.readTree(objectMapper.writeValueAsString(book)));
                Book patched = objectMapper.treeToValue(target, Book.class);
                repository.save(patched);
                return patched;
            } catch (JsonProcessingException | JsonPatchException e) {
                log.error("Error updating book {}", id, e);
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public Book updateBook(String id, BookDto updateRequest) {
        Book book = repository.getById(Long.valueOf(id));
        if (book != null) {
            book.update(updateRequest);
            repository.save(book);
            return book;
        } else {
            return null;
        }
    }
}

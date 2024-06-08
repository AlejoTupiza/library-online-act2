package com.unir.back_end_library_books.data;

import com.unir.back_end_library_books.data.utils.SearchCriteria;
import com.unir.back_end_library_books.data.utils.SearchOperation;
import com.unir.back_end_library_books.data.utils.SearchStatement;
import com.unir.back_end_library_books.model.pojo.Book;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepository {

    private final BookJpaRepository repository;

    public List<Book> getBooks() { return repository.findAll(); }

    public Book getById(Long id) { return repository.findById(id).orElse(null); }

    public List<Book> search(String title, String author) {
        SearchCriteria<Book> spec = new SearchCriteria<>();
        if (StringUtils.isNotBlank(title)) {
            spec.add(new SearchStatement("title", title, SearchOperation.MATCH));
        }
//        if (StringUtils.isNotBlank(author)) {
//            spec.add(new SearchStatement("author", author, SearchOperation.MATCH));
//        }
        return repository.findAll(spec);
    }
}

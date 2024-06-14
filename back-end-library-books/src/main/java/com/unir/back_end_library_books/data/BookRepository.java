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

    public Book save(Book book) { return repository.save(book); }

    public void delete(Book book) { repository.delete(book); }

    public List<Book> search(Long isbn, String title, Integer yearPublication, Integer stock,
                             String synopsis, String criticism, String author, String gender) {
        SearchCriteria<Book> spec = new SearchCriteria<>();

        if (isbn != null) {
            spec.add(new SearchStatement("isbn", isbn, SearchOperation.EQUAL));
        }

        if (StringUtils.isNotBlank(title)) {
            spec.add(new SearchStatement("title", title, SearchOperation.MATCH));
        }

        if (yearPublication != null) {
            spec.add(new SearchStatement("yearPublication", yearPublication, SearchOperation.EQUAL));
        }

        if (stock != null) {
            spec.add(new SearchStatement("stock", stock, SearchOperation.EQUAL));
        }

        if (StringUtils.isNotBlank(synopsis)) {
            spec.add(new SearchStatement("synopsis", synopsis, SearchOperation.MATCH));
        }

        if (StringUtils.isNotBlank(criticism)) {
            spec.add(new SearchStatement("criticism", criticism, SearchOperation.MATCH));
        }

        if (StringUtils.isNotBlank(author)) {
            spec.add(new SearchStatement("author.name", author, SearchOperation.MATCH));
        }

        if (StringUtils.isNotBlank(gender)) {
            spec.add(new SearchStatement("gender.name", gender, SearchOperation.MATCH));
        }
        return repository.findAll(spec);
    }
}

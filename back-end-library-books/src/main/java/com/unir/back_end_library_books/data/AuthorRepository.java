package com.unir.back_end_library_books.data;

import com.unir.back_end_library_books.data.utils.SearchCriteria;
import com.unir.back_end_library_books.data.utils.SearchOperation;
import com.unir.back_end_library_books.data.utils.SearchStatement;
import com.unir.back_end_library_books.model.pojo.Author;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AuthorRepository {
    private final AuthorJpaRepository repository;

    public List<Author> getAuthors() {
        return repository.findAll();
    }

    public Author getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Author save(Author author) {
        return repository.save(author);
    }

    public void delete(Author author) {
        repository.delete(author);
    }

    public List<Author> search(String name, String country, String description, Boolean visible) {
        SearchCriteria<Author> spec = new SearchCriteria<>();
        if (StringUtils.isNotBlank(name)) {
            spec.add(new SearchStatement("name", name, SearchOperation.MATCH));
        }

        if (StringUtils.isNotBlank(last_name)) {
            spec.add(new SearchStatement("last_name", last_name, SearchOperation.MATCH));
        }

        return repository.findAll(spec);
    }
}

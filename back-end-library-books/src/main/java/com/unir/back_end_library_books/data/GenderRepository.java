package com.unir.back_end_library_books.data;

import com.unir.back_end_library_books.data.utils.SearchCriteriaGender;
import com.unir.back_end_library_books.data.utils.SearchOperation;
import com.unir.back_end_library_books.data.utils.SearchStatement;
import com.unir.back_end_library_books.model.pojo.Gender;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GenderRepository {

    private final GenderJpaRepository repository;

    public List<Gender> getGenders() {
        return repository.findAll();
    }

    public Gender getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Gender save(Gender gender) {
        return repository.save(gender);
    }

    public void delete(Gender gender) {
        repository.delete(gender);
    }

    public List<Gender> search(String name) {
        SearchCriteriaGender<Gender> spec = new SearchCriteriaGender<>();
        if (StringUtils.isNotBlank(name)) {
            spec.add(new SearchStatement("name", name, SearchOperation.MATCH));
        }

        return repository.findAll(spec);
    }

}

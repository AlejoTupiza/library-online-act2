package com.unir.back_end_library_books.repositories;

import com.unir.back_end_library_books.model.pojo.Gender;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Genderrepository extends CrudRepository<Gender, Long> {
}

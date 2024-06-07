package com.unir.back_end_library_books.data;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.unir.back_end_library_books.model.pojo.Author;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
interface AuthorJpaRepository extends JpaRepository<Author, Long>, JpaSpecificationExecutor<Author> {
    List<Author> findByName(String name);

    List<Author> findByLastname(String last_name);

}

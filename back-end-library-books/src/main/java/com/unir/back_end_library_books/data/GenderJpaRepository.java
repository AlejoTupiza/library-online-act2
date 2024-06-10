package com.unir.back_end_library_books.data;

import com.unir.back_end_library_books.model.pojo.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

interface GenderJpaRepository extends JpaRepository<Gender, Long>, JpaSpecificationExecutor<Gender> {

	List<Gender> findByName(String name);



}

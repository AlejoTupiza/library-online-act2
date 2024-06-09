package com.unir.back_end_library_books.model.request;

import com.unir.back_end_library_books.model.pojo.Author;
import com.unir.back_end_library_books.model.pojo.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookRequest {

    private Long isbn;
    private String title;
    private Integer yearPublication;
    private Integer stock;
    private String imgBook;
    private String synopsis;
    private String criticism;
    private Author author;
    private Gender gender;
}

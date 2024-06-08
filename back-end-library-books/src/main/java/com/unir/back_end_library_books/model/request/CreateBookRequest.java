package com.unir.back_end_library_books.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookRequest {
    private String title;
    private String author;
    private String gender;
    private String isbn;
    private Integer year_publication;
    private Integer stock;
    private String synopsis;
    private String criticism;
}

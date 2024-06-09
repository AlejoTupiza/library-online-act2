package com.unir.back_end_library_books.model.pojo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BookDto {

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

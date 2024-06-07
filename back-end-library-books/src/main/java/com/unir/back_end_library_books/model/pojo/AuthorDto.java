package com.unir.back_end_library_books.model.pojo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AuthorDto {
    private String name;
    private String last_name;
}

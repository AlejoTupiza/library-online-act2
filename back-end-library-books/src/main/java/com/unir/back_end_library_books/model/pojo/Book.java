package com.unir.back_end_library_books.model.pojo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "isbn", unique = true)
    private int isbn;
    @Column(name = "title", unique = true)
    private String title;
    @Column(name = "year_publication")
    private int yearPublication;
    @Column(name = "stock")
    private int stock;
    @Column(name = "imgBook")
    private String imgBook;
    @Column(name = "synopsis")
    private String synopsis;
    @Column(name = "criticism")
    private String criticism;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "gender_id", nullable = false)
    private Gender gender;
}

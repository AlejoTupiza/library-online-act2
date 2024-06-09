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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "isbn", unique = true, nullable = false)
    private long isbn;

    @Column(name = "title", unique = true, nullable = false, length = 128)
    private String title;

    @Column(name = "year_publication")
    private int yearPublication;

    @Column(name = "stock")
    private int stock;

    @Column(name = "img_book", length = 255)
    private String imgBook;

    @Column(name = "synopsis", columnDefinition = "TEXT")
    private String synopsis;

    @Column(name = "criticism", columnDefinition = "TEXT")
    private String criticism;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "gender_id", nullable = false)
    private Gender gender;

    public void update(BookDto bookDto) {
        this.isbn = bookDto.getIsbn();
        this.title = bookDto.getTitle();
        this.yearPublication = bookDto.getYearPublication();
        this.stock = bookDto.getStock();
        this.imgBook = bookDto.getImgBook();
        this.synopsis = bookDto.getSynopsis();
        this.criticism = bookDto.getCriticism();
        this.author = bookDto.getAuthor();
        this.gender = bookDto.getGender();
    }
}

package com.unir.backendlibraryoperator.model.pojo;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "rentaldetail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RentalDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "rental_day")
    private Date rentalDay;
    @Column(name = "number_day")
    private Integer numberDay;
    @Column(name = "return_day")
    private Date returnDay;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "book_Id", nullable = false)
    private Long book_Id;
    @ManyToOne
    @JoinColumn(name = "rental_Id", nullable = false)
    private Rental rental;
    @Override
    public String toString() {
        return "RentalDetail{" +
                "id=" + id +
                ", rentalDay=" + rentalDay +
                ", numberDay=" + numberDay +
                ", returnDate='" + returnDay + '\'' +
                ", bookId=" + book_Id +
                ", amount=" + amount +
                '}';
    }
}

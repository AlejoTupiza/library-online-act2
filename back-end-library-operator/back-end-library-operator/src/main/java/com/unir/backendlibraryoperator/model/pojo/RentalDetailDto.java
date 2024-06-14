package com.unir.backendlibraryoperator.model.pojo;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RentalDetailDto {
    private String rentDate;
    private Integer numberDay;
    private String returnDate;
    private Long bookId;
    private Integer amount;
}

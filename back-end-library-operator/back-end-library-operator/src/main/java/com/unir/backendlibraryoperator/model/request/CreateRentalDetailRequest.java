package com.unir.backendlibraryoperator.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalDetailRequest {
    private Date rentDate;
    private Integer numberDay;
    private Date returnDate;
    private Long bookId;
    private Integer amount;
}

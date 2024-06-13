package com.unir.backendlibraryoperator.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalRequest {
    private Date rentalDate;
    private List<CreateRentalDetailRequest > rentalDetailRequestLists;
}

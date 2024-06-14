package com.unir.backendlibraryoperator.service;

import com.unir.backendlibraryoperator.model.pojo.Rental;
import com.unir.backendlibraryoperator.model.pojo.RentalDto;
import com.unir.backendlibraryoperator.model.request.CreateRentalRequest;

import java.util.Date;
import java.util.List;

public interface RentalService {
    RentalDto createRental(CreateRentalRequest request);
    List<RentalDto> getRentals();
    RentalDto getRental(String id);
    List<RentalDto> getRentals(Date rentDate,Integer numberDay,Date returnDate);

}

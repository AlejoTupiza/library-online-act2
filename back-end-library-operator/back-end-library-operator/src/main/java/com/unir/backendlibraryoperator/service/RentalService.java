package com.unir.backendlibraryoperator.service;

import com.unir.backendlibraryoperator.model.pojo.Rental;
import com.unir.backendlibraryoperator.model.pojo.RentalDto;
import com.unir.backendlibraryoperator.model.request.CreateRentalRequest;

import java.util.List;

public interface RentalService {
    RentalDto createRental(CreateRentalRequest request);
    List<RentalDto> getRentals();
}

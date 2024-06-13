package com.unir.backendlibraryoperator.data;

import com.unir.backendlibraryoperator.model.pojo.Rental;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RentalRepository {
    private final RentalJpaRepository repository;

    public List<Rental> getRentals() {return  repository.findAll();}
    public Rental getRentalById(Long id) {return repository.findById(id).orElse(null);}
    public Rental save(Rental rental) { return repository.save(rental);}
}

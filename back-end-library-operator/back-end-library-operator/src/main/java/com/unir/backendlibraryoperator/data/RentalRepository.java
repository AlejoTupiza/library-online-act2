package com.unir.backendlibraryoperator.data;

import com.unir.backendlibraryoperator.data.utils.SearchCriteria;
import com.unir.backendlibraryoperator.data.utils.SearchOperation;
import com.unir.backendlibraryoperator.data.utils.SearchStatement;
import com.unir.backendlibraryoperator.model.pojo.Rental;
import com.unir.backendlibraryoperator.model.pojo.RentalDto;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RentalRepository {
    private final RentalJpaRepository repository;

    public List<Rental> getRentals() {return  repository.findAll();}
    public Rental getRentalById(Long id) {return repository.findById(id).orElse(null);}
    public Rental save(Rental rental) { return repository.save(rental);}
    public List<Rental> getRentals(Date rentDate, Integer numberDay, Date returnDate) {
        SearchCriteria<Rental> spec = new SearchCriteria<>();

        if (rentDate != null) {
            spec.add(new SearchStatement("rentDate", rentDate, SearchOperation.EQUAL));
        }
        /*if (numberDay != null) {
            spec.add(new SearchStatement("rent_date", rentDate, SearchOperation.EQUAL));
        }
        if (returnDate != null) {
            spec.add(new SearchStatement("rent_date", rentDate, SearchOperation.EQUAL));
        }*/
        return repository.findAll(spec);
    }
}

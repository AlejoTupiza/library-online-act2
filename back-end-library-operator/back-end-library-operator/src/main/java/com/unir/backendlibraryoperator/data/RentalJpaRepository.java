package com.unir.backendlibraryoperator.data;

import com.unir.backendlibraryoperator.model.pojo.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RentalJpaRepository extends JpaRepository<Rental,Long>, JpaSpecificationExecutor<Rental> {

}

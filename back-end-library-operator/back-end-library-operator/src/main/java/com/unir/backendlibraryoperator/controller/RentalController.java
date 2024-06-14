package com.unir.backendlibraryoperator.controller;

import com.unir.backendlibraryoperator.model.pojo.Rental;
import com.unir.backendlibraryoperator.model.pojo.RentalDto;
import com.unir.backendlibraryoperator.model.request.CreateRentalRequest;
import com.unir.backendlibraryoperator.service.RentalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Rental Controller", description = "Microservicio encargado de guardar los pedidos de renta de libros en una base de datos.")
public class RentalController {
    private final RentalService service;
    @GetMapping("/rentals")
    public ResponseEntity<List<RentalDto>> getRentals(
            @RequestHeader Map<String, String> headers,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")Date rentDate,
            @RequestParam(required = false) Integer numberDay,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")Date returnDate
    )
    {
        List<RentalDto> rentals = service.getRentals(rentDate,numberDay,returnDate);
        if(rentals != null)
        {
            return ResponseEntity.ok(rentals);
        }else{
            return ResponseEntity.ok(Collections.emptyList());
        }
    }
    @PostMapping("/rentals")
    @Operation(
            operationId = "Insertar alquiler",
            description = "Operación de escritura",
            summary = "Se creak un nuevo registro de alquiler de libro",
            requestBody =  @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos de los libros que se van a alquilar.",
                    required = true,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CreateRentalRequest.class))))
    @ApiResponse(
            responseCode = "201",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Rental.class )))
    @ApiResponse(
            responseCode = "400",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "Datos incorrectos introducidos.")
    public ResponseEntity<RentalDto> addRental(@RequestBody CreateRentalRequest request) {

        RentalDto createdBookRental = service.createRental(request);

        if (createdBookRental != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBookRental);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/rentals/{id}")
    public ResponseEntity<RentalDto> getRental(@PathVariable String id) {
        log.info("Request received for rental {}", id);
        RentalDto rental = service.getRental(id);

        if (rental != null) {
            return ResponseEntity.ok(rental);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

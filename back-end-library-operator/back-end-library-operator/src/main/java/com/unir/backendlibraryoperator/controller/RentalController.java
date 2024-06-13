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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Rental Controller", description = "Microservicio encargado de guardar los pedidos de renta de libros en una base de datos.")
public class RentalController {
    private final RentalService service;
    @GetMapping("/rentals")
    public ResponseEntity<List<RentalDto>> getRentals()
    {
        List<RentalDto> rentals = service.getRentals();
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
}

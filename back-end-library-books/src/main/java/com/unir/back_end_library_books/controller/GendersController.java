package com.unir.back_end_library_books.controller;

import com.unir.back_end_library_books.model.pojo.Gender;
import com.unir.back_end_library_books.model.pojo.GenderDto;
import com.unir.back_end_library_books.model.request.CreateGenderRequest;
import com.unir.back_end_library_books.service.GendersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Genders Controller", description = "Microservicio encargado de exponer operaciones CRUD sobre Genderos alojados en una base de datos en memoria.")
public class GendersController {

    private final GendersService service;

    @GetMapping("/Genders")
    @Operation(
            operationId = "Obtener Genderos",
            description = "Operacion de lectura",
            summary = "Se devuelve una lista de todos los Genderos almacenados en la base de datos.")
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Gender.class)))
    public ResponseEntity<List<Gender>> getGenders(
            @RequestHeader Map<String, String> headers,
            @Parameter(name = "name", description = "Nombre del Gendero. No tiene por que ser exacto", example = "iPhone", required = false)
            @RequestParam(required = false) String name) {

        log.info("headers: {}", headers);
        List<Gender> Genders = service.getGenders(name);

        if (Genders != null) {
            return ResponseEntity.ok(Genders);
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }

    @GetMapping("/Genders/{GenderId}")
    @Operation(
            operationId = "Obtener un Gendero",
            description = "Operacion de lectura",
            summary = "Se devuelve un Gendero a partir de su identificador.")
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Gender.class)))
    @ApiResponse(
            responseCode = "404",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "No se ha encontrado el Gendero con el identificador indicado.")
    public ResponseEntity<Gender> getGender(@PathVariable String GenderId) {

        log.info("Request received for Gender {}", GenderId);
        Gender Gender = service.getGender(GenderId);

        if (Gender != null) {
            return ResponseEntity.ok(Gender);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/Genders/{GenderId}")
    @Operation(
            operationId = "Eliminar un Gendero",
            description = "Operacion de escritura",
            summary = "Se elimina un Gendero a partir de su identificador.")
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)))
    @ApiResponse(
            responseCode = "404",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "No se ha encontrado el Gendero con el identificador indicado.")
    public ResponseEntity<Void> deleteGender(@PathVariable String GenderId) {

        Boolean removed = service.removeGender(GenderId);

        if (Boolean.TRUE.equals(removed)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/Genders")
    @Operation(
            operationId = "Insertar un Gendero",
            description = "Operacion de escritura",
            summary = "Se crea un Gendero a partir de sus datos.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos del Gendero a crear.",
                    required = true,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CreateGenderRequest.class))))
    @ApiResponse(
            responseCode = "201",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Gender.class)))
    @ApiResponse(
            responseCode = "400",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "Datos incorrectos introducidos.")
    @ApiResponse(
            responseCode = "404",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "No se ha encontrado el Gendero con el identificador indicado.")
    public ResponseEntity<Gender> addGender(@RequestBody CreateGenderRequest request) {

        Gender createdGender = service.createGender(request);

        if (createdGender != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdGender);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    @PatchMapping("/Genders/{GenderId}")
    @Operation(
            operationId = "Modificar parcialmente un Gendero",
            description = "RFC 7386. Operacion de escritura",
            summary = "RFC 7386. Se modifica parcialmente un Gendero.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos del Gendero a crear.",
                    required = true,
                    content = @Content(mediaType = "application/merge-patch+json", schema = @Schema(implementation = String.class))))
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Gender.class)))
    @ApiResponse(
            responseCode = "400",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "Gendero inválido o datos incorrectos introducidos.")
    public ResponseEntity<Gender> patchGender(@PathVariable String GenderId, @RequestBody String patchBody) {

        Gender patched = service.updateGender(GenderId, patchBody);
        if (patched != null) {
            return ResponseEntity.ok(patched);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    @PutMapping("/Genders/{GenderId}")
    @Operation(
            operationId = "Modificar totalmente un Gendero",
            description = "Operacion de escritura",
            summary = "Se modifica totalmente un Gendero.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos del Gendero a actualizar.",
                    required = true,
                    content = @Content(mediaType = "application/merge-patch+json", schema = @Schema(implementation = GenderDto.class))))
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Gender.class)))
    @ApiResponse(
            responseCode = "404",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "Gendero no encontrado.")
    public ResponseEntity<Gender> updateGender(@PathVariable String GenderId, @RequestBody GenderDto body) {

        Gender updated = service.updateGender(GenderId, body);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

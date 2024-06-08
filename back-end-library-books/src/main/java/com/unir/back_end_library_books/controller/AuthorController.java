package com.unir.back_end_library_books.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.unir.back_end_library_books.model.pojo.AuthorDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.unir.back_end_library_books.model.pojo.Author;

import com.unir.back_end_library_books.model.request.CreateAuthorRequest;
import com.unir.back_end_library_books.service.AuthorService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Author Controller", description = "Microservicio encargado de exponer operaciones CRUD sobre libros, autores y categorias alojados en una base de datos en memoria.")
public class AuthorController {
    private final AuthorService service;
    @GetMapping("/authors")
    @Operation(
            operationId = "Obtener autores",
            description = "Operacion de lectura",
            summary = "Se devuelve una lista de todos los autores en la base de datos.")
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json",schema = @Schema(implementation = Author.class)))
    public ResponseEntity<List<Author>> getAuthors(
            @RequestHeader Map<String,String>headers,
            @Parameter(name="name", description ="Nombre del autor. No tiene que ser exacto", example="Carlos", required = false)
            @RequestParam(required = false) String name,
            @Parameter(name="last_name", description ="Apellido del autor. No tiene que ser exacto", example="Neruda", required = false)
            @RequestParam(required = false) String last_name){
        log.info("headers:{}",headers);
        List<Author> authors=service.getAuthors(name,last_name);
        if (authors != null){
            return ResponseEntity.ok(authors);
        }else {
            return ResponseEntity.ok(Collections.emptyList());
        }

    }
}

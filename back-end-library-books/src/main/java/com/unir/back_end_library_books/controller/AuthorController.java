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
}

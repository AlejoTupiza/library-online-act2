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


    @GetMapping("/authors/{authorId}")
    @Operation(
            operationId = "Obtener un autor",
            description = "Operacion de lectura",
            summary = "Se devuelve un autor a partir de su identificador.")
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Author.class)))
    @ApiResponse(
            responseCode = "404",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "No se ha encontrado el autor con el identificador indicado.")
    public ResponseEntity<Author> getProduct(@PathVariable String authorId) {

        log.info("Request received for author {}", authorId);
        Author author = service.getAuthor(authorId);

        if (author != null) {
            return ResponseEntity.ok(author);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/authors/{authorId}")
    @Operation(
            operationId = "Eliminar un autor",
            description = "Operacion de escritura",
            summary = "Se elimina un autor a partir de su identificador.")
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)))
    @ApiResponse(
            responseCode = "404",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "No se ha encontrado el autor con el identificador indicado.")
    public ResponseEntity<Void> deleteAuthor(@PathVariable String authorId) {

        Boolean removed = service.removeAuthor(authorId);

        if (Boolean.TRUE.equals(removed)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/authors")
    @Operation(
            operationId = "Insertar un autor",
            description = "Operacion de escritura",
            summary = "Se crea un autor a partir de sus datos.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos del autor a crear.",
                    required = true,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CreateAuthorRequest.class))))
    @ApiResponse(
            responseCode = "201",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Author.class)))
    @ApiResponse(
            responseCode = "400",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "Datos incorrectos introducidos.")
    @ApiResponse(
            responseCode = "404",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "No se ha encontrado el autor con el identificador indicado.")
    public ResponseEntity<Author> addAuthor(@RequestBody CreateAuthorRequest request) {

        Author createdAuthor = service.createAuthor(request);

        if (createdAuthor != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAuthor);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/authors/{authorId}")
    @Operation(
            operationId = "Modificar parcialmente un autor",
            description = "RFC 7386. Operacion de escritura",
            summary = "RFC 7386. Se modifica parcialmente un autor.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos del autor a modificar.",
                    required = true,
                    content = @Content(mediaType = "application/merge-patch+json", schema = @Schema(implementation = String.class))))
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Author.class)))
    @ApiResponse(
            responseCode = "400",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "Autor inválido o datos incorrectos introducidos.")
    public ResponseEntity<Author> patchAuthor(@PathVariable String authorId, @RequestBody String patchBody) {

        Author patched = service.updateAuthor(authorId, patchBody);
        if (patched != null) {
            return ResponseEntity.ok(patched);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    @PutMapping("/authors/{authorId}")
    @Operation(
            operationId = "Modificar totalmente un autor",
            description = "Operacion de escritura",
            summary = "Se modifica totalmente un autor.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos del autor a actualizar.",
                    required = true,
                    content = @Content(mediaType = "application/merge-patch+json", schema = @Schema(implementation = AuthorDto.class))))
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Author.class)))
    @ApiResponse(
            responseCode = "404",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "Autor no encontrado.")
    public ResponseEntity<Author> updateAuthor(@PathVariable String authorId, @RequestBody AuthorDto body) {

        Author updated = service.updateAuthor(authorId, body);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

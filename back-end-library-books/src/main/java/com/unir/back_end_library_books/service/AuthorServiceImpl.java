package com.unir.back_end_library_books.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import com.unir.back_end_library_books.data.AuthorRepository;
import com.unir.back_end_library_books.model.pojo.AuthorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.unir.back_end_library_books.model.pojo.Author;
import com.unir.back_end_library_books.model.request.CreateAuthorRequest;
@Service
@Slf4j
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<Author> getAuthors(String name, String last_name) {

        if (StringUtils.hasLength(name) || StringUtils.hasLength(last_name))
                 {
            return repository.search(name,last_name);
        }

        List<Author> author = repository.getAuthors();
        return author.isEmpty() ? null : author;
    }

    @Override
    public Author getAuthor(String authorId) {
        return repository.getById(Long.valueOf(authorId));
    }

    @Override
    public Boolean removeAuthor(String authorId) {

        Author author = repository.getById(Long.valueOf(authorId));

        if (author != null) {
            repository.delete(author);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public Author createAuthor(CreateAuthorRequest request) {

        //Otra opcion: Jakarta Validation: https://www.baeldung.com/java-validation
        if (request != null && StringUtils.hasLength(request.getName().trim())
                && StringUtils.hasLength(request.getLast_name().trim())) {

                    Author author = Author.builder().name(request.getName()).last_name(request.getLast_name()).build();

            return repository.save(author);
        } else {
            return null;
        }
    }

    @Override
    public Author updateAuthor(String authorId, String request) {

        //PATCH se implementa en este caso mediante Merge Patch: https://datatracker.ietf.org/doc/html/rfc7386
        Author author = repository.getById(Long.valueOf(authorId));
        if (author != null) {
            try {
                JsonMergePatch jsonMergePatch = JsonMergePatch.fromJson(objectMapper.readTree(request));
                JsonNode target = jsonMergePatch.apply(objectMapper.readTree(objectMapper.writeValueAsString(author)));
                Author patched = objectMapper.treeToValue(target, Author.class);
                repository.save(patched);
                return patched;
            } catch (JsonProcessingException | JsonPatchException e) {
                log.error("Error updating author {}", authorId, e);
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public Author updateAuthor(String authorId, AuthorDto updateRequest) {
        Author author = repository.getById(Long.valueOf(authorId));
        if (author != null) {
            author.update(updateRequest);
            repository.save(author);
            return author;
        } else {
            return null;
        }
    }

}

package com.unir.back_end_library_books.service;

import java.util.List;

import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import com.unir.back_end_library_books.model.pojo.Author;
import com.unir.back_end_library_books.model.pojo.AuthorDto;
import com.unir.back_end_library_books.model.request.CreateAuthorRequest;

public class AuthorService {
    List<Author> getAuthor(String name, String last_name);

    Author getAuthor(String authorId);

    Boolean removeAuthor(String authorId);

    Author createAuthor(CreateAuthorRequest request);

    Author updateAuthor(String authorId, String updateRequest);

    Author updateAuthor(String authorId, AuthorDto updateRequest);

}

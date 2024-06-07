package com.unir.back_end_library_books.controller;

import com.unir.back_end_library_books.model.pojo.Gender;
import com.unir.back_end_library_books.services.Genderservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/gender")
public class GenderController {
    @Autowired
    Genderservices genderservices;
    @GetMapping()
    public ArrayList<Gender> getGenders() {
        return genderservices.obtenerGeneros();
    }
    @PostMapping()
    public Gender addGender(@RequestBody Gender gender) {
        return genderservices.guardarGender(gender);
    }
}

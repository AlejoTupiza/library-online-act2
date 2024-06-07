package com.unir.back_end_library_books.services;

import com.unir.back_end_library_books.model.pojo.Gender;
import com.unir.back_end_library_books.repositories.Genderrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Genderservices {
    @Autowired
    Genderrepository genderrepository;
    public ArrayList<Gender>obtenerGeneros(){
        return (ArrayList<Gender>)genderrepository.findAll();
    }

    public Gender guardarGender(Gender gender){
        return genderrepository.save(gender);
    }
}

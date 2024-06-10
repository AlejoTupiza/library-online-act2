package com.unir.back_end_library_books.service;

import com.unir.back_end_library_books.model.pojo.Gender;
import com.unir.back_end_library_books.model.pojo.GenderDto;
import com.unir.back_end_library_books.model.request.CreateGenderRequest;

import java.util.List;

public interface GendersService {
	
	List<Gender> getGenders(String name);
	
	Gender getGender(String GenderId);
	
	Boolean removeGender(String GenderId);
	
	Gender createGender(CreateGenderRequest request);

	Gender updateGender(String GenderId, String updateRequest);

	Gender updateGender(String GenderId, GenderDto updateRequest);

}

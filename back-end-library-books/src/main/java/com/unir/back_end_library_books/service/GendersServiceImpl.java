package com.unir.back_end_library_books.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import com.unir.back_end_library_books.data.GenderRepository;
import com.unir.back_end_library_books.model.pojo.Gender;
import com.unir.back_end_library_books.model.pojo.GenderDto;
import com.unir.back_end_library_books.model.request.CreateGenderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Slf4j
public class GendersServiceImpl implements GendersService {

	@Autowired
	private GenderRepository repository;

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public List<Gender> getGenders(String name) {

		if (StringUtils.hasLength(name) ) {
			return repository.search(name);
		}

		List<Gender> Genders = repository.getGenders();
		return Genders.isEmpty() ? null : Genders;
	}

	@Override
	public Gender getGender(String GenderId) {
		return repository.getById(Long.valueOf(GenderId));
	}

	@Override
	public Boolean removeGender(String GenderId) {

		Gender Gender = repository.getById(Long.valueOf(GenderId));

		if (Gender != null) {
			repository.delete(Gender);
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

	@Override
	public Gender createGender(CreateGenderRequest request) {

		//Otra opcion: Jakarta Validation: https://www.baeldung.com/java-validation
		if (request != null && StringUtils.hasLength(request.getName().trim())) {

			Gender gender = Gender.builder().name(request.getName()).build();

			return repository.save(gender);
		} else {
			return null;
		}
	}

	@Override
	public Gender updateGender(String GenderId, String request) {

		//PATCH se implementa en este caso mediante Merge Patch: https://datatracker.ietf.org/doc/html/rfc7386
		Gender Gender = repository.getById(Long.valueOf(GenderId));
		if (Gender != null) {
			try {
				JsonMergePatch jsonMergePatch = JsonMergePatch.fromJson(objectMapper.readTree(request));
				JsonNode target = jsonMergePatch.apply(objectMapper.readTree(objectMapper.writeValueAsString(Gender)));
				Gender patched = objectMapper.treeToValue(target, Gender.class);
				repository.save(patched);
				return patched;
			} catch (JsonProcessingException | JsonPatchException e) {
				log.error("Error updating Gender {}", GenderId, e);
                return null;
            }
        } else {
			return null;
		}
	}

	@Override
	public Gender updateGender(String GenderId, GenderDto updateRequest) {
		Gender Gender = repository.getById(Long.valueOf(GenderId));
		if (Gender != null) {
			Gender.update(updateRequest);
			repository.save(Gender);
			return Gender;
		} else {
			return null;
		}
	}

}

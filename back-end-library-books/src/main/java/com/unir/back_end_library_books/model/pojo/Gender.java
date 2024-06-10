package com.unir.back_end_library_books.model.pojo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "genders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Gender {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", unique = true)
	private String name;
	

	public void update(GenderDto genderDto) {
		this.name = genderDto.getName();
	}

}

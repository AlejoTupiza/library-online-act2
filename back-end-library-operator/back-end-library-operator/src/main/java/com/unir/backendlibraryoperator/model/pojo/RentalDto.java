package com.unir.backendlibraryoperator.model.pojo;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RentalDto {
    private Long id;
    private String rentDate;
    private List<RentalDetailDto> rentalDetails;
}

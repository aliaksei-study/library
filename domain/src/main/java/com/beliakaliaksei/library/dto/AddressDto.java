package com.beliakaliaksei.library.dto;

import com.beliakaliaksei.library.validator.Character;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
public class AddressDto {
    private Long id;
    @Character
    private String region;
    @Character
    private String city;
    @Character
    private String street;
    @Min(value = 0, message = "{valid.numberOfStreet.min}")
    @Max(1_000)
    private int numberOfStreet;
}

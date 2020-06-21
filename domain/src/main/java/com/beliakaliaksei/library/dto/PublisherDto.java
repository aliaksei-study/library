package com.beliakaliaksei.library.dto;

import com.beliakaliaksei.library.entity.enumeration.Country;
import com.beliakaliaksei.library.validator.NullEmailValidator;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
public class PublisherDto {
    private Long id;
    private Country country;
    @Valid
    private AddressDto addressDto;
    @Min(value = 0, message = "{valid.postcode.min}")
    @Max(1_000_000)
    private Integer postcode;
    @NullEmailValidator
    private String email;
}

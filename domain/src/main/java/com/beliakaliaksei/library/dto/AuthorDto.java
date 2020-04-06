package com.beliakaliaksei.library.dto;

import com.beliakaliaksei.library.entity.enumeration.Gender;
import com.beliakaliaksei.library.validator.Character;
import com.beliakaliaksei.library.validator.NullOrFullDate;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class AuthorDto {
    private Long id;
    @Character
    private String name;
    @Character
    private String surname;
    @NullOrFullDate
    private Date dateOfBirth;
    private Gender gender;
    private String note;
}

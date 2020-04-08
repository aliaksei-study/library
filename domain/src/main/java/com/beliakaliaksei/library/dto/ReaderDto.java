package com.beliakaliaksei.library.dto;

import com.beliakaliaksei.library.entity.enumeration.Gender;
import com.beliakaliaksei.library.validator.CellPhone;
import com.beliakaliaksei.library.validator.Character;
import com.beliakaliaksei.library.validator.NullOrFullDate;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@NoArgsConstructor
public class ReaderDto {
    private Long id;
    @Character
    private String name;
    @Character
    private String surname;
    @NullOrFullDate
    private Date dateOfBirth;
    private Gender gender;
    @NotNull(message = "Must input reader registration info")
    @Valid
    private UserDto userDto;
    @CellPhone
    private String phone;
    @Valid
    private PhotoDto photoDto;
}

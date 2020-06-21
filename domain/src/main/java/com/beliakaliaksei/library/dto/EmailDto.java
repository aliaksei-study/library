package com.beliakaliaksei.library.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class EmailDto {
    private Long id;
    @NotNull(message = "{valid.email.subjectNotNull}")
    private String subject;
    @NotNull(message = "{valid.email.bodyNotNull}")
    private String text;
}

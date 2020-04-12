package com.beliakaliaksei.library.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class CoverDto {
    private Long id;
    private PhotoDto photoDto;
    private Date dateOfUpload;
    private String note;
}

package com.beliakaliaksei.library.dto;

import com.beliakaliaksei.library.entity.enumeration.Genre;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@NoArgsConstructor
public class BookDto {
    private Long id;
    @NotNull(message = "{valid.title.notNull}")
    private String title;
    @Valid
    private PublisherDto publisherDto;
    @NotNull(message = "{valid.publicationDate.notNull}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publicationDate;
    @Min(value = 0, message = "{valid.numberOfCopies.min}")
    @Max(100_000_000)
    private int numberOfCopies;
    private Genre genre;
}

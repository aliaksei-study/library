package com.beliakaliaksei.library.dto;

import com.beliakaliaksei.library.entity.Book;
import com.beliakaliaksei.library.entity.Reader;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@NoArgsConstructor
public class BookKeeperDto {
    private Long id;
    @NotNull(message = "{valid.date.notNull}")
    private Date dateOfIssue;
    @NotNull(message = "{valid.date.notNull}")
    private Date returnDate;
    @NotNull(message = "{valid.book.notNull}")
    private Long bookId;
    @NotNull(message = "{valid.reader.notNull}")
    private Long readerId;
}

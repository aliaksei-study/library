package com.beliakaliaksei.library.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "book_keeper")
public class BookKeeper implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date_of_issue")
    private Date dateOfIssue;

    @Column(name = "return_date")
    private Date returnDate;

    @OneToOne(mappedBy = "book_keeper")
    @Column(name="book")
    private Book book;

    @OneToOne(mappedBy = "book_keeper")
    @Column(name="reader")
    private Reader reader;
}

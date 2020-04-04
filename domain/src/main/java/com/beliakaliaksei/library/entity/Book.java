package com.beliakaliaksei.library.entity;

import com.beliakaliaksei.library.entity.enumeration.Genre;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @Column(name="publication_date")
    private Date publicationDate;

    @Column(name="number_of_copies")
    private int numberOfCopies;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre_id")
    private Genre genre;

    @ManyToMany
    @JoinTable (name = "author_book",
                joinColumns = @JoinColumn(name = "book_id"),
                inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "book")
    private List<Cover> covers;
}

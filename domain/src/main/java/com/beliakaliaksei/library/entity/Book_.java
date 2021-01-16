package com.beliakaliaksei.library.entity;

import com.beliakaliaksei.library.entity.*;
import com.beliakaliaksei.library.entity.enumeration.Genre;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.sql.Date;

@StaticMetamodel(Book.class)
public class Book_ {
    public static volatile SingularAttribute<Book, Long> id;
    public static volatile SingularAttribute<Book, String> title;
    public static volatile SingularAttribute<Book, Publisher> publisher;
    public static volatile SingularAttribute<Book, Date> publicationDate;
    public static volatile SingularAttribute<Book, Integer> numberOfCopies;
    public static volatile SingularAttribute<Book, Genre> genre;
    public static volatile SingularAttribute<Book, Reader> reader;
    public static volatile SingularAttribute<Book, BookKeeper> bookKeeper;
    public static volatile ListAttribute<Book, Author> authors;
    public static volatile ListAttribute<Book, Cover> covers;
}

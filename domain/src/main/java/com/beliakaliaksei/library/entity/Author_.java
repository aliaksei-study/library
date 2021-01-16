package com.beliakaliaksei.library.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Author.class)
public class Author_ extends Human_ {
    public static volatile SingularAttribute<Author, String> note;
}

package com.beliakaliaksei.library.entity;

import com.beliakaliaksei.library.entity.Human;
import com.beliakaliaksei.library.entity.enumeration.Gender;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.sql.Date;

@StaticMetamodel(Human.class)
public class Human_ {
    public static volatile SingularAttribute<Human, Long> id;
    public static volatile SingularAttribute<Human, String> name;
    public static volatile SingularAttribute<Human, String> surname;
    public static volatile SingularAttribute<Human, Date> dateOfBirth;
    public static volatile SingularAttribute<Human, Gender> gender;
}

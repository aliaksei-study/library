package com.beliakaliaksei.library.entity;

import com.beliakaliaksei.library.entity.enumeration.Gender;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "reader")
public class Reader extends Human implements Serializable {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usr_id")
    private User user;

    @Column(name = "phone")
    private String phone;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "photo_id")
    private Photo photo;
}

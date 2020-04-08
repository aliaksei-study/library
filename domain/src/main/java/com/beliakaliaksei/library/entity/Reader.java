package com.beliakaliaksei.library.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id")
    private Photo photo;

    @OneToOne(mappedBy = "reader")
    private Book book;
}

package com.beliakaliaksei.library.entity;

import com.beliakaliaksei.library.entity.enumeration.Country;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "publisher")
public class Publisher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated (EnumType.STRING)
    @Column(name = "country_id")
    private Country country;

    @OneToOne(mappedBy = "publisher", cascade = CascadeType.ALL)
    @Column(name = "address_id")
    private Address address;

    @Column(name = "postcode")
    private int postcode;

    @Column(name = "email")
    private String email;

}

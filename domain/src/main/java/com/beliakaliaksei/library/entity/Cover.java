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
@Table(name = "cover")
public class Cover implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "photo_id")
    private Photo photo;

    @Column(name = "date_of_upload")
    private Date dateOfUpload;

    @Column(name = "note")
    private String note;

    @ManyToOne
    private Book book;
}

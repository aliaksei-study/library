package com.beliakaliaksei.library.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

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

    @OneToMany(mappedBy = "cover", cascade = CascadeType.ALL)
    @Column(name = "photo_id")
    private List<Photo> photo;

    @Column(name = "date_of_upload")
    private Date dateOfUpload;

    @Column(name = "note")
    private String note;
}

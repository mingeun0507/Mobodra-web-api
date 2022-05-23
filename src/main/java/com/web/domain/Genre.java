package com.web.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@Table(name = "Genre")
public class Genre {

    @Id
    @Column(name = "GENRE_ID")
    private Long id;

    @Column(name = "name")
    private String name;

}

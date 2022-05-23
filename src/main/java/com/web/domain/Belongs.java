package com.web.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@Table(name = "Belongs")
public class Belongs {

    @Id
    @Column(name = "BELONGS_ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "CONTENT_ID")
    private Content content;

    @OneToOne
    @JoinColumn(name = "GENRE_ID")
    private Genre genre;
}

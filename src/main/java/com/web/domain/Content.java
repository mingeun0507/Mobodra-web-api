package com.web.domain;

import com.web.domain.enums.ContentType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@Table(name = "Content")
public class Content {

    @Id
    @Column(name = "CONTENT_ID")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private String year;

    @Column(name = "image_link")
    private String imageLink;
}

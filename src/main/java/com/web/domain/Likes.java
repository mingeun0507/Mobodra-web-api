package com.web.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "LIKES")
public class Likes {

    @Id
    @Column(name = "LIKES_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "CONTENT_ID")
    private Content content;

    @OneToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
}

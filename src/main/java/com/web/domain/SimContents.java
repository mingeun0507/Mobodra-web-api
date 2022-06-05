package com.web.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "sim_contents")
public class SimContents {

    @Id
    @Column(name = "CONTENT_ID", nullable = false)
    private Long id;

    @Column(name = "sim1")
    private Long sim1;

    @Column(name = "sim2")
    private Long sim2;

    @Column(name = "sim3")
    private Long sim3;

    @Column(name = "sim4")
    private Long sim4;

    @Column(name = "sim5")
    private Long sim5;

    @Column(name = "sim6")
    private Long sim6;

    @Column(name = "sim7")
    private Long sim7;

    @Column(name = "sim8")
    private Long sim8;

    @Column(name = "sim9")
    private Long sim9;

    @Column(name = "sim10")
    private Long sim10;

    @Column(name = "sim11")
    private Long sim11;

    @Column(name = "sim12")
    private Long sim12;

    @Column(name = "sim13")
    private Long sim13;

    @Column(name = "sim14")
    private Long sim14;

    @Column(name = "sim15")
    private Long sim15;

    @Column(name = "sim16")
    private Long sim16;



}

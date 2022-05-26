package com.web.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "sim_contents")
public class SimContents {

    @Id
    @Column(name = "CONTENT_ID", nullable = false)
    private Long id;

    @Id
    @Column(name = "sim1")
    private String sim1;

    @Id
    @Column(name = "sim2")
    private String sim2;

    @Id
    @Column(name = "sim3")
    private String sim3;

    @Id
    @Column(name = "sim4")
    private String sim4;

    @Id
    @Column(name = "sim5")
    private String sim5;

    @Id
    @Column(name = "sim6")
    private String sim6;

    @Id
    @Column(name = "sim7")
    private String sim7;

    @Id
    @Column(name = "sim8")
    private String sim8;

    @Id
    @Column(name = "sim9")
    private String sim9;

    @Id
    @Column(name = "sim10")
    private String sim10;

    @Id
    @Column(name = "sim11")
    private String sim11;

    @Id
    @Column(name = "sim12")
    private String sim13;

    @Id
    @Column(name = "sim14")
    private String sim14;

    @Id
    @Column(name = "sim15")
    private String sim15;

    @Id
    @Column(name = "sim16")
    private String sim16;



}

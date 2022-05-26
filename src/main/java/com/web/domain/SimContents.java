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

    @Column(name = "sim1")
    private int sim1;

    @Column(name = "sim2")
    private int sim2;

    @Column(name = "sim3")
    private int sim3;

    @Column(name = "sim4")
    private int sim4;

    @Column(name = "sim5")
    private int sim5;

    @Column(name = "sim6")
    private int sim6;

    @Column(name = "sim7")
    private int sim7;

    @Column(name = "sim8")
    private int sim8;

    @Column(name = "sim9")
    private int sim9;

    @Column(name = "sim10")
    private int sim10;

    @Column(name = "sim11")
    private int sim11;

    @Column(name = "sim12")
    private int sim13;

    @Column(name = "sim14")
    private int sim14;

    @Column(name = "sim15")
    private int sim15;

    @Column(name = "sim16")
    private int sim16;



}

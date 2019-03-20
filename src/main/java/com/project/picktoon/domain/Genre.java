package com.project.picktoon.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//CREATE TABLE IF NOT EXISTS genre (
//        id INT NOT NULL AUTO_INCREMENT,
//        genre_name VARCHAR(45) NOT NULL,
//        ordering INT NULL,
//        PRIMARY KEY (id));

@Entity
@Table(name = "genre")
@Setter
@Getter
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 45)
    private String genreName;

    @Column
    private int ordering;

}

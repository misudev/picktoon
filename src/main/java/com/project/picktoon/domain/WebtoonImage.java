package com.project.picktoon.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name = "webtoon_image")
@Setter
@Getter
@ToString
public class WebtoonImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String name;

    @Column(length = 45)
    private String mimeType;

    @Column
    private Long length;

    @Column(length = 255)
    private String saveFileName;
}

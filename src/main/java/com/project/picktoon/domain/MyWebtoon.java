package com.project.picktoon.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "my_webtoon")
@Setter
@Getter
public class MyWebtoon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}

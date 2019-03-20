package com.project.picktoon.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "my_webtoon")
@Setter
@Getter
@ToString
public class MyWebtoon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int ordering;

    @OneToOne
    @JoinColumn (name="webtoon_id")
    private Long webtoonId;
}

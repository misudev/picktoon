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
<<<<<<< HEAD
    @Column(name = "webtoon_id")
    private Long WebtoonId;
    @Column
    private int alarm;
    @Column(name = "user_id")
    private Long UserId;
=======

    @Column
    private int ordering;

    @OneToOne
    @JoinColumn (name="webtoon_id")
    private Long webtoonId;
>>>>>>> 24c1325cc30dd292f83cc64bfc35a551d4d0595f
}

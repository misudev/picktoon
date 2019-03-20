package com.project.picktoon.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "new_webtoon")
@Setter
@Getter
@ToString
public class NewWebtoon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int ordering;

    @OneToOne
<<<<<<< HEAD
    @JoinColumn (name="webtoon_id")
    private Webtoon webtoon;
}
=======
    @JoinColumn(name = "webtoon_id")
    private Webtoon webtoon;
}
>>>>>>> 24c1325cc30dd292f83cc64bfc35a551d4d0595f

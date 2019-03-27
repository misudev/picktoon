package com.project.picktoon.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "new_webtoon")
@Setter
@Getter
public class NewWebtoon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int ordering;

    @OneToOne
    @JoinColumn(name = "webtoon_id")
    private Webtoon webtoon;

    @Override
    public String toString() {
        return "NewWebtoon{" +
                "id=" + id +
                ", ordering=" + ordering +
                ", webtoonId=" + webtoon.getId()+
                '}';
    }
}

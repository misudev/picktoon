package com.project.picktoon.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "webtoon")
@Setter
@Getter
@ToString
public class Webtoon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;


    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String seeAge;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private int subscription;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "platform_id")
    private Platform platform;

    @ManyToMany
    @JoinTable(
            name = "webtoon_keyword",
            joinColumns = @JoinColumn(name = "webtoon_id" , referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "keyword_id", referencedColumnName = "id")
    )
    private List<Keyword> keywords;
<<<<<<< HEAD
=======

>>>>>>> 24c1325cc30dd292f83cc64bfc35a551d4d0595f

    public Webtoon(){
        seeAge = "전체관람가";
        subscription = 0;
    }


}

package com.project.picktoon.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
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

    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "webtoon_state_id")
    private WebtoonState webtoonState;

    @ManyToOne
    @JoinColumn(name = "platform_id")
    private Platform platform;

<<<<<<< HEAD
=======
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "webtoon_image_id")
    private WebtoonImage webtoonImage;

>>>>>>> 1a23de9e3f7cebfdfb3aed8e777a54fe8b1c2e96
    @ManyToMany
    @JoinTable(
            name = "webtoon_keyword",
            joinColumns = @JoinColumn(name = "webtoon_id" , referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "keyword_id", referencedColumnName = "id")
    )
    private List<Keyword> keywords;


    public Webtoon(){
        seeAge = "전체관람가";
        subscription = 0;
        keywords = new ArrayList<>();
    }


    public void addKeyword(Keyword keyword){
        keywords.add(keyword);
    }
}


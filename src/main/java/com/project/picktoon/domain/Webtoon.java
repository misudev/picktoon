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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "webtoon")
    @JoinColumn(name = "webtoon_id")
    private WebtoonState webtoonState;

    @ManyToOne(targetEntity=Platform.class, fetch=FetchType.LAZY)
    @JoinColumn(name = "platform_id")
    private Platform platform;

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

    @Override
    public String toString() {
        return "Webtoon{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", keywords=" + keywords +
                '}';
    }

    public void addKeyword(Keyword keyword){
        keywords.add(keyword);
    }
}

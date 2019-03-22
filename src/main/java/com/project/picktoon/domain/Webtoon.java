package com.project.picktoon.domain;

import lombok.Getter;
import lombok.Setter;

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

    @ManyToOne
    @JoinColumn(name = "platform_id")
    private Platform platform;

    //부모
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "webtoon")
    @JoinColumn(name = "webtoon_id")
    private WebtoonState webtoonState;

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
        return  " id :" + id + '\n' +
                " 제목 : " + title + '\n' +
                " 상태 : " + state + '\n' +
                " 관람대상 : " + seeAge + '\n' +
                " 주소(링크): " + link + '\n' +
                " 구독자수 : " + subscription + '\n' +
                " 간단소개 : " + description + '\n' +
                " 플랫폼 : " + platform + '\n' +
                " 키워드 : " + keywords+ '\n';
    }
}

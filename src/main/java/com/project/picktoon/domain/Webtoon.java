package com.project.picktoon.domain;

import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "webtoon")
@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
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

    @Column(name = "update_state")
    private Boolean updateState;

    @Column(name = "updated_date")
    private Date updatedDate;

    @Column(name = "total_count")
    private String totalCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "platform_id")
    private Platform platform;

    @OneToMany(mappedBy = "webtoon", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<WebtoonImage> webtoonImages;

    @Column(name = "created_date")
    private Date createdDate;

    @ManyToMany
    @JoinTable(
            name = "webtoon_keyword",
            joinColumns = @JoinColumn(name = "webtoon_id" , referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "keyword_id", referencedColumnName = "id")
    )
    private List<Keyword> keywords;


    public Webtoon(){
        seeAge = "전체관람가";
        state = "연재중";
        subscription = 0;
        keywords = new ArrayList<>();
        webtoonImages = new ArrayList<>();
        createdDate = new Date();
        updateState = false;
    }


    public void addKeyword(Keyword keyword){
        keywords.add(keyword);
    }

    public void addWebtoonImage(WebtoonImage webtoonImage) {
        if(webtoonImages == null)
            webtoonImages = new ArrayList<>();
        webtoonImage.setWebtoon(this); // 쌍방향이기 때문에 this를 참조하도록 한다.
        webtoonImages.add(webtoonImage);
    }
}


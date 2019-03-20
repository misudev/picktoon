package com.project.picktoon.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

//CREATE TABLE IF NOT EXISTS webtoon (
//        id BIGINT(20) NOT NULL AUTO_INCREMENT,
//        title VARCHAR(45) NOT NULL,
//        author VARCHAR(45) NOT NULL,
//        state VARCHAR(45) NOT NULL,
//        see_age VARCHAR(45) NOT NULL DEFAULT '전체관람가',
//        link VARCHAR(255) NOT NULL,
//        subscription INT NOT NULL DEFAULT 0,
//        description LONGTEXT NULL,
//        platform_id INT NOT NULL,
//        PRIMARY KEY (id),
//        CONSTRAINT fk_webtoon_platform
//        FOREIGN KEY (platform_id)
//        REFERENCES platform (id)
//        ON DELETE NO ACTION
//        ON UPDATE NO ACTION);

@Entity
@Table(name = "webtoon")
@Setter
@Getter
public class Webtoon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

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
            name = "webtoon_genre",
            joinColumns = @JoinColumn(name = "webtoon_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id")
    )
    private List<Genre> genres;

    @ManyToMany
    @JoinTable(
            name = "webtoon_keyword",
            joinColumns = @JoinColumn(name = "webtoon_id" , referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "keyword_id", referencedColumnName = "id")
    )
    private List<Genre> keywords;

    @ManyToMany
    @JoinTable(
            name = "webtoon_day",
            joinColumns = @JoinColumn(name = "webtoon_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "day_id", referencedColumnName = "id")
    )
    private List<Genre> days;

    public Webtoon(){
        seeAge = "전체관람가";
        subscription = 0;
    }


}

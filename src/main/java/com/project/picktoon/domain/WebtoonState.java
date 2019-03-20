package com.project.picktoon.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "webtoon")
@Setter
@Getter
@ToString
public class WebtoonState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Boolean updateState;

    @Column
    private Date updateDate;

    @Column
    private String totalCount;

    @OneToOne
    @JoinColumn(name = "webtoon_id")
    private Webtoon webtoon;

}

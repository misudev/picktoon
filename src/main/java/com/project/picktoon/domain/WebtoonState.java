package com.project.picktoon.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "webtoon_state")
@Setter
@Getter
public class WebtoonState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "update_state")
    private Boolean updateState;

    @Column(name = "updated_date")
    private Date updatedDate;

    @Column(name = "total_count")
    private String totalCount;

    @OneToOne
    @JoinColumn(name = "webtoon_id")
    private Webtoon webtoon;

    @Override
    public String toString() {
        return "WebtoonState{" +
                "id=" + id +
                ", updateState=" + updateState +
                ", updatedDate=" + updatedDate +
                ", totalCount='" + totalCount + '\'' +
                '}';
    }
}

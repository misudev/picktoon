package com.project.picktoon.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

<<<<<<< HEAD
    @Column
=======
    @Column(name = "updated_date")
>>>>>>> 1536989a83e316143dc1b17b62f943ad481ee5c5
    private Date updatedDate;

    @Column(name = "total_count")
    private String totalCount;

    @OneToOne(fetch = FetchType.LAZY)
<<<<<<< HEAD
    private Webtoon webtoon;
=======
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
>>>>>>> 1536989a83e316143dc1b17b62f943ad481ee5c5
}

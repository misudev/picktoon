package com.project.picktoon.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

//CREATE TABLE IF NOT EXISTS webtoon_state (
//        id BIGINT(20) NOT NULL AUTO_INCREMENT,
//        update_state TINYINT(1) NULL,
//        updated_date DATETIME NULL,
//        total_count VARCHAR(255) NULL,
//        webtoon_id BIGINT(20) NOT NULL,
//        CONSTRAINT fk_webtoon_state_webtoon
//        FOREIGN KEY (webtoon_id)
//        REFERENCES webtoon(id)
//        ON DELETE CASCADE
//        ON UPDATE CASCADE,
//        PRIMARY KEY (id));

@Entity
@Table(name = "webtoon")
@Setter
@Getter
public class WebtoonState {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

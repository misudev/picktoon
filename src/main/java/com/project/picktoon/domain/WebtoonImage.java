package com.project.picktoon.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

//CREATE TABLE IF NOT EXISTS webtoon_image (
//        id BIGINT(20) NOT NULL AUTO_INCREMENT,
//        mime_type VARCHAR(45) NULL,
//        length BIGINT(20) NULL,
//        name VARCHAR(45) NULL,
//        save_file_name VARCHAR(255) NULL,
//        webtoon_id BIGINT(20) NOT NULL,
//        PRIMARY KEY (id),
//        CONSTRAINT fk_webtoon_image_webtoon
//        FOREIGN KEY (webtoon_id)
//        REFERENCES webtoon(id)
//        ON DELETE NO ACTION
//        ON UPDATE NO ACTION);

@Entity
@Table(name = "webtoon")
@Setter
@Getter
@ToString
public class WebtoonImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String name;

    @Column(length = 45)
    private String mimeType;

    @Column
    private Long length;

    @Column(length = 255)
    private String saveFileName;

    @OneToOne
    @JoinColumn(name = "webtoon_id")
    private Webtoon webtoon;
}

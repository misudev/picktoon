package com.project.picktoon.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity
@Table(name = "platform")
@Setter
@Getter
public class Platform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="platform_name")
    private String platformName;

//    @OneToMany(mappedBy = "platform")
//    private List<Webtoon> webtoons;

}


package com.project.picktoon.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "keyword")
@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Keyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int keywordType;

    @Column(length = 45)
    private String keywordValue;

    @Column
    private int ordering;

}

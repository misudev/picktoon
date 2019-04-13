package com.project.picktoon.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "platform")
@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Platform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="platform_name")
    private String platformName;
}




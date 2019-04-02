package com.project.picktoon.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddWebtoon {
    private String title;
    private String state;
    private String seeAge;
    private String link;
    private int subscription;
    private String description;
    private int platformId;
    private Long webtoonImageId;
}

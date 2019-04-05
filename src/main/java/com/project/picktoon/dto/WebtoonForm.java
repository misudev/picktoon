package com.project.picktoon.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class WebtoonForm {
    //웹툰 정보
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String state;
    @NotNull
    private String seeAge;
    @NotNull
    private String link;
    private int subscription;
    @NotNull
    private String description;
    @NotNull
    private int platformId;
    private Long webtoonImageId;
    private Long webtoonStateId;
    private List<KeywordDto> keywords;
}

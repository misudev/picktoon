package com.project.picktoon.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class WebtoonDto {
    //웹툰 정보
    private Long id;
    private String title;
    private String state;
    private String seeAge;
    private String link;
    private int subscription;
    private String description;
    private String platformName;
    private Long webtoonImageId;
    private Long webtoonStateId;
    private List<KeywordDto> keywords;
    //웹툰 상태 정보
    private WebtoonStateDto webtoonState;

}

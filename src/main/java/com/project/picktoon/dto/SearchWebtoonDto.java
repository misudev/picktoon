package com.project.picktoon.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchWebtoonDto {
    private Long id;
    private String title;
    private String seeAge;
    private Long webtoonImageId;
    private List<KeywordDto> keywords;
    private WebtoonStateDto webtoonState;
}

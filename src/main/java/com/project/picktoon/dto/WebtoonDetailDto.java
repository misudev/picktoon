package com.project.picktoon.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WebtoonDetailDto {
    //웹툰 정보
    private Long id;
    private String title;
    private String state;
    private String seeAge;
    private String link;
    private int subscription;
    private String description;
    private String platformName;

    private Boolean updateState;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date updatedDate;
    private String totalCount;

    private List<KeywordDto> keywords;

    private Boolean myWebtoon;

    private Long userId;

    private Long webtoonImageId = -1L;

    private Long mywebtoonId;

}
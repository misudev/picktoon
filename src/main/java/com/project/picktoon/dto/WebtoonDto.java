package com.project.picktoon.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class WebtoonDto {
    @NotNull
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

}

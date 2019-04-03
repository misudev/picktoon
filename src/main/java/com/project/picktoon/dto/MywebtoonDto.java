package com.project.picktoon.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class MywebtoonDto {
    @NotNull
    private Long id;
    private Boolean alarm;
    @NotNull
    private Long webtoonId;
    @NotNull
    @Size(min=1, max=45)
    private String webtoonTitle;
    @NotNull
    private Long userId;
    @NotNull
    private Long webtoonImageId;
    @NotNull
    private String updateDate;
    @NotNull
    @Size(min=1, max=45)
    private String totalCount;
}

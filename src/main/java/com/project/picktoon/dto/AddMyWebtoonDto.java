package com.project.picktoon.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AddMyWebtoonDto {
    @NotNull
    private Long userId;
    @NotNull
    private Long webtoonId;
}

package com.project.picktoon.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date webtoonUpdatedDate;
    @NotNull
    @Size(min=1, max=45)
    private String webtoonTotalCount;
}

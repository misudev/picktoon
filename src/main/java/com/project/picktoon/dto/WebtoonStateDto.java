package com.project.picktoon.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class WebtoonStateDto {
    private Boolean updateState;
    private String updatedDate; //String으로 수정..
    private String totalCount;
}

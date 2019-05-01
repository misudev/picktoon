package com.project.picktoon.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class DeleteMyWebtoonDto {
    private String result;
    private Long myWebtoonId;

    public DeleteMyWebtoonDto(String result){
        this.result = result;
    }
}

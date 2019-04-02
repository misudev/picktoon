package com.project.picktoon.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchWebtoonDto {
    private String searchStr;
    private List<SearchKeyword> keywords;
}

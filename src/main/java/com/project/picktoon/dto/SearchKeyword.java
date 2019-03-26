package com.project.picktoon.dto;

import lombok.Data;

@Data
public class SearchKeyword {

    private int keyWordType;
    private String keyWordValue;

    public int getKeyWordType() {
        return keyWordType;
    }

    public String getKeyWordValue() {
        return keyWordValue;
    }
}



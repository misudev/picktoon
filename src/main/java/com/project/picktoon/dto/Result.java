package com.project.picktoon.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Result {
    private String result;

    public Result(String result){
        this.result = result;
    }
}

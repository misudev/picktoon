package com.project.picktoon.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateAlarmDto {
    private int count;
    private String title;

    public UpdateAlarmDto(int count, String title){
        this.count = count;
        this.title = title;
    }
}

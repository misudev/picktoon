package com.project.picktoon.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KeywordDto {
    private Long id;
    private int keywordType;
    private String keywordValue;

}

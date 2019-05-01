package com.project.picktoon.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class WebtoonImageDto {
    private Long id;
    private String saveFileName;
}

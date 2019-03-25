package com.project.picktoon.service;

import com.project.picktoon.domain.NewWebtoon;

public interface NewWebtoonService {
    public NewWebtoon updateNewWebtoon(Long webtoonId, int ordering);
}

package com.project.picktoon.service;

import com.project.picktoon.domain.NewWebtoon;

public interface NewWebtoonService {
    public NewWebtoon getNewWebtoonById(int id);
    public NewWebtoon updateNewWebtoon(int id, Long webtoonId, int ordering);
}

package com.project.picktoon.service;

import com.project.picktoon.domain.NewWebtoon;
import com.project.picktoon.domain.Webtoon;

import java.util.List;

public interface NewWebtoonService {
    public NewWebtoon getNewWebtoonById(int id);
    public List<NewWebtoon> getNewWebtoons();
    public NewWebtoon updateNewWebtoon(int id, Long webtoonId, int ordering);
}

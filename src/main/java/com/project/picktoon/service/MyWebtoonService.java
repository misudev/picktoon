package com.project.picktoon.service;

import com.project.picktoon.domain.MyWebtoon;

import java.util.List;

public interface MyWebtoonService {
    public MyWebtoon addMyWebtoon(Long userId, Long webtoonId);
    public void deleteMyWebtoon(Long myWebtoonId);
    public void changeAlarm(Long myWebtoonId);
    public List<MyWebtoon> getMyWebtoons(Long userId, int orderType);
}

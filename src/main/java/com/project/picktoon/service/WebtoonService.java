package com.project.picktoon.service;

import com.project.picktoon.domain.Keyword;
import com.project.picktoon.domain.Webtoon;
import com.project.picktoon.dto.SearchKeyword;

import java.util.List;

public interface WebtoonService {
    public List<Webtoon> getWebtoons(List<SearchKeyword> keywords, String searchStr);
    public Webtoon getWebtoonByTitle(String title);
    public Webtoon getWebtoonById(Long id);
    public List<Webtoon> getBestWebtoons();
    public Webtoon addWebtoon(Webtoon webtoon);
    public void updateWebtoon(Webtoon webtoon);
    public void deleteWebtoon(Long id);



}

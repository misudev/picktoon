package com.project.picktoon.repository.custom;

import com.project.picktoon.domain.Webtoon;
import com.project.picktoon.dto.SearchKeyword;

import java.util.List;

public interface WebtoonRepositoryCustom {
    public List<Webtoon> getWebtoons(List<SearchKeyword> keywords, String searchStr);
}

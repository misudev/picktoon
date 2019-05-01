package com.project.picktoon.service;

import com.project.picktoon.domain.Keyword;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface KeywordService {
    public Keyword addKeyword(Keyword keyword);
    public void deleteKeyword(Long keywordId);
    public Keyword getKeywordById(Long keywordId);
    public List<Keyword> getKeywordsByType(int type);
    public List<Keyword> getBestKeywords (int type, Pageable pageable);
    public Keyword getAuthorByName(String name);
    public Keyword getKeywordByValue(String value);
    public Keyword getKeywordByTypeAndValue(int type, String value);
}

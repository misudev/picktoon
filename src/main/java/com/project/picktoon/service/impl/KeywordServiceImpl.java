package com.project.picktoon.service.impl;

import com.project.picktoon.domain.Keyword;
import com.project.picktoon.repository.KeywordRepository;
import com.project.picktoon.service.KeywordService;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KeywordServiceImpl implements KeywordService {
    public final KeywordRepository keywordRepository;

    @Override
    @Transactional(readOnly = true)
    public Keyword getKeywordById(Long keywordId) {
        return keywordRepository.findById(keywordId).get();
    }

    @Override
    @Transactional
    public Keyword addKeyword(Keyword keyword) {
        return keywordRepository.save(keyword);
    }

    @Override
    @Transactional
    public void deleteKeyword(Long keywordId) {
        keywordRepository.deleteById(keywordId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Keyword> getKeywordsByType(int type) {
        return keywordRepository.getKeywordsByType(type);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Keyword> getBestKeywords(int type, Pageable pageable) {
        return keywordRepository.getBestKeywords(type, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Keyword getAuthorByName(String name) {
        return keywordRepository.getAuthorByName(name);
    }
}

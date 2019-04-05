package com.project.picktoon.controller.api;

import com.project.picktoon.domain.Keyword;
import com.project.picktoon.service.KeywordService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/keywords")
@RequiredArgsConstructor
public class KeywordApiController {
    private final KeywordService keywordService;

    @GetMapping("/{keywordId}")
    public Keyword getKeyword(@PathVariable("keywordId")Long id){
        return keywordService.getKeywordById(id);
    }

    @PostMapping
    public void addKeyword(@RequestBody Keyword keyword){
        keywordService.addKeyword(keyword);
    }

    @DeleteMapping("/{keywordId}")
    public void deleteKeyword(@PathVariable("keywordId") Long keywordId){
        keywordService.deleteKeyword(keywordId);
    }

    @GetMapping
    public List<Keyword> getKeywords(@RequestParam(name = "keywordType") int type ) {
        return keywordService.getKeywordsByType(type);
    }

    @GetMapping("/bestkeywords")
    public List<Keyword> getBestKeywords(@RequestParam(name = "keywordType") int type ){
        Pageable pageable = PageRequest.of(0,10);
        return keywordService.getBestKeywords(type, pageable);
    }
}


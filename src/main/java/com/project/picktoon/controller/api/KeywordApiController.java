package com.project.picktoon.controller.api;

import com.project.picktoon.domain.Keyword;
import com.project.picktoon.service.KeywordService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/keywords")
@RequiredArgsConstructor
public class KeywordApiController {
    private final KeywordService keywordService;

    @GetMapping("/{keywordId}")
    public ResponseEntity<Keyword> getKeyword(@PathVariable("keywordId")Long id){
        Keyword keyword = keywordService.getKeywordById(id);
        return new ResponseEntity<>(keyword, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Keyword> addKeyword(@RequestBody Keyword keyword){
        Keyword addKeyword = keywordService.addKeyword(keyword);
        return new ResponseEntity<>(addKeyword, HttpStatus.CREATED);
    }

    @DeleteMapping("/{keywordId}")
    public ResponseEntity deleteKeyword(@PathVariable("keywordId") Long keywordId){
        if(keywordService.getKeywordById(keywordId)==null)
            return new ResponseEntity(HttpStatus.NO_CONTENT);

        keywordService.deleteKeyword(keywordId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Keyword>> getKeywords(@RequestParam(name = "keywordType") int type ) {
        List<Keyword> keywords =  keywordService.getKeywordsByType(type);
        if(keywords.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(keywords, HttpStatus.OK);
    }

    @GetMapping("/bestkeywords")
    public ResponseEntity<List<Keyword>> getBestKeywords(@RequestParam(name = "keywordType") int type ){
        Pageable pageable = PageRequest.of(0,10);
        List<Keyword> keywords =  keywordService.getBestKeywords(type, pageable);
        if(keywords.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(keywords, HttpStatus.OK);
    }
}


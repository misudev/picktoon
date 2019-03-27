package com.project.picktoon.service;

import com.project.picktoon.domain.Keyword;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KeywordServiceTest {

    @Autowired
    KeywordService keywordService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void 키워드_키워드바이아이디(){
        Keyword keyword = keywordService.getKeywordById(1L);
        System.out.println(keyword.toString());

    }

    @Test
    public void 키워드_키워드추가하기(){
        Keyword keyword = new Keyword();
        keyword.setKeywordType(3);
        keyword.setKeywordValue("토토");
        keywordService.addKeyword(keyword);
        System.out.println(keyword);
    }

    @Test
    public void 키워드_키워드지우기(){
        keywordService.deleteKeyword(50L);
    }

    @Test
    public void 키워드_키워드타입으로가져오기(){
        List<Keyword> keywords = keywordService.getKeywordsByType(3);
        System.out.println(keywords);
    }

    @Test
    public void 키워드_베스트키워드가져오기(){
        Pageable pageable = PageRequest.of(0,5);
        List<Keyword> keywords = keywordService.getBestKeywords(4, pageable);
        for(Keyword k : keywords){
            System.out.println(k);
        }

    }

}

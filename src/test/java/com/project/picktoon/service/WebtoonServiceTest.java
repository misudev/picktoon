package com.project.picktoon.service;

import com.project.picktoon.domain.Keyword;
import com.project.picktoon.domain.Webtoon;
import com.project.picktoon.dto.SearchKeyword;
import com.project.picktoon.util.SeeAge;
import com.querydsl.core.Tuple;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebtoonServiceTest {

    @Autowired
    WebtoonService webtoonService;

    @Autowired
    PlatformService platformService;

    @Autowired
    KeywordService keywordService;

    @Before
    public void setUp() throws Exception {
        Webtoon newWebtoon = new Webtoon();
        newWebtoon.setTitle("테스트 웹툰21");
        newWebtoon.setDescription("테스트 웹툰 입니다.");
        newWebtoon.setLink("www.naver.com");
        newWebtoon.setPlatform(platformService.getPlatformById(1));
        newWebtoon.setSeeAge(SeeAge.SEEAGE_ALL);
        newWebtoon.setState("연재중");
        newWebtoon.setSubscription(100);
        Keyword keyword1 = keywordService.getKeywordById(1L);
        Keyword keyword2 = keywordService.getKeywordById(2L);
        newWebtoon.addKeyword(keyword1);
        newWebtoon.addKeyword(keyword2);
        webtoonService.addWebtoon(newWebtoon);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void 웹툰update() throws Exception{
        System.out.println(webtoonService.getWebtoonById(21L));

        Webtoon webtoon = new Webtoon();
        webtoon.setId(21L);
        webtoon.setTitle("수정된 Title");
        webtoon.setSeeAge("전체관람가");
        webtoon.setDescription("수정된 웹툰 입니다.");
        webtoon.setState("연재중단");
        webtoon.setSubscription(200);
        webtoon.setLink("www.naver.com");
        webtoon.setPlatform(platformService.getPlatformById(2));
        Keyword keyword1 = keywordService.getKeywordById(3L);
        Keyword keyword2 = keywordService.getKeywordById(4L);
        webtoon.addKeyword(keyword1);
        webtoon.addKeyword(keyword2);
        webtoonService.updateWebtoon(webtoon);

        System.out.println(webtoonService.getWebtoonById(21L));
    }

    @Test
    public void 웹툰_검색하기() throws Exception{
        SearchKeyword searchKeyword1 = new SearchKeyword();
        searchKeyword1.setKeywordType(1);
        searchKeyword1.setKeywordValue("월");
        SearchKeyword searchKeyword2 = new SearchKeyword();
        searchKeyword2.setKeywordType(2);
        searchKeyword2.setKeywordValue("코믹");

        List<SearchKeyword> searchKeywords = new ArrayList<>();
        searchKeywords.add(searchKeyword1);
        searchKeywords.add(searchKeyword2);

        List<Webtoon> webtoons = webtoonService.getWebtoons(searchKeywords, null);

//        for(Webtoon w : webtoons)
//            System.out.println(w);

    }
}
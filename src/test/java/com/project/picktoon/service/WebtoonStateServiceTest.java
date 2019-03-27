package com.project.picktoon.service;

import com.project.picktoon.domain.Keyword;
import com.project.picktoon.domain.Webtoon;
import com.project.picktoon.domain.WebtoonState;
import com.project.picktoon.util.SeeAge;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebtoonStateServiceTest {
    @Autowired
    WebtoonStateService webtoonStateService;
    @Autowired
    WebtoonService webtoonService;
    @Autowired
    KeywordService keywordService;
    @Autowired
    PlatformService platformService;

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
    public void 웹툰상태_추가() throws Exception{
        WebtoonState webtoonState = new WebtoonState();
        webtoonState.setUpdateState(true);
        webtoonState.setUpdatedDate(new Date());
        webtoonState.setTotalCount("17화");
        webtoonState.setWebtoon(webtoonService.getWebtoonById(21L));

        Assert.assertEquals(webtoonState, webtoonStateService.addWebtoonState(21L, webtoonState));
    }

    @Test
    public void 웹툰상태_수정() throws Exception{
        //기존 웹툰 상태 : (20, 1, '2019-03-18 00:33:30', '3부 2화', 20)
        WebtoonState webtoonState = new WebtoonState();
        //id , updateState, updatedDate, totalCount 값 설정.
        webtoonState.setId(20L);
        webtoonState.setUpdateState(false);
        webtoonState.setUpdatedDate(new Date());
        webtoonState.setTotalCount("3부 3화");
        //웹툰 수정
        System.out.println("웹툰상태 수정----");
        webtoonStateService.updateWebtoonState(webtoonState);
        System.out.println("-------수정 끝");
        System.out.println(webtoonStateService.getWebtoonStateById(20L));
    }


}
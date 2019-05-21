package com.project.picktoon.service;

import com.project.picktoon.domain.NewWebtoon;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewWebtoonServiceTest {

    @Autowired
    NewWebtoonService newWebtoonService;
    @Autowired
    WebtoonService webtoonService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void 뉴웹툰_아이디로가져오기(){
        NewWebtoon newWebtoon = newWebtoonService.getNewWebtoonById(1);
        System.out.println(newWebtoon);
    }

//    @Test
//    public void 뉴웹툰_새로운뉴웹툰(){
//        NewWebtoon newWebtoon1 = newWebtoonService.updateNewWebtoon(3,18L, 3);
//        System.out.println(newWebtoon1);
//    }
}

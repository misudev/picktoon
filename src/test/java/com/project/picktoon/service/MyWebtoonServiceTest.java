package com.project.picktoon.service;

import com.project.picktoon.domain.MyWebtoon;
import com.project.picktoon.service.impl.MyWebtoonServiceImpl;
import com.project.picktoon.service.impl.WebtoonServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MyWebtoonServiceTest {

    @Autowired
    MyWebtoonService myWebtoonService;

    @Autowired
    WebtoonService webtoonService;

    @Before
    public void setUp() throws Exception {
        int subscriptions = webtoonService.getWebtoonById(1L).getSubscription();

        //웹툰을 구독한다 (userId = 2, webtoonId = 1)
        MyWebtoon newMyWebtoon = myWebtoonService.addMyWebtoon(2L, 1L);
        //구독자수 1 증가 확인
        Assert.assertEquals(subscriptions+1, webtoonService.getWebtoonById(1L).getSubscription());

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void 웹툰삭제시_마이웹툰삭제(){
        MyWebtoon myWebtoon = myWebtoonService.getMyWebtoonById(1L);
        Long webtoonId = myWebtoon.getWebtoon().getId();

        webtoonService.deleteWebtoon(webtoonId);
        Assert.assertEquals(myWebtoonService.getMyWebtoonById(1L),null);

    }

    @Test
    @Transactional
    public void 마이웹툰추가(){
        int subscriptions = webtoonService.getWebtoonById(1L).getSubscription();

        //웹툰을 구독한다 (userId = 2, webtoonId = 1)
        MyWebtoon newMyWebtoon = myWebtoonService.addMyWebtoon(2L, 1L);
        //구독자수 1 증가 확인
        Assert.assertEquals(subscriptions+1, webtoonService.getWebtoonById(1L).getSubscription());

    }

    @Test
    @Transactional
    public void 알람변경(){
        boolean before = myWebtoonService.getMyWebtoonById(1L).getAlarm();
        myWebtoonService.changeAlarm(1L);
        Assert.assertNotEquals(before, myWebtoonService.getMyWebtoonById(1L).getAlarm());
    }


}
package com.project.picktoon.service;

import com.project.picktoon.domain.WebtoonImage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebtoonImageServiceTest {

    @Autowired
    WebtoonImageService webtoonImageService;
    @Autowired
    WebtoonService webtoonService;

    @Before
    public void setUp() throws Exception {
        WebtoonImage webtoonImage = new WebtoonImage();

        webtoonImage.setLength(255L);
        webtoonImage.setMimeType("aaaaa");
        webtoonImage.setName("sssss");
        webtoonImage.setSaveFileName("kkkkk");

        WebtoonImage webtoonImage1 = webtoonImageService.addWebtoonImage(webtoonImage);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void 이미지_이미지추가하기(){
        WebtoonImage webtoonImage = new WebtoonImage();

        webtoonImage.setLength(255L);
        webtoonImage.setMimeType("aaaaa");
        webtoonImage.setName("sssss");
        webtoonImage.setSaveFileName("kkkkk");

        WebtoonImage webtoonImage1 = webtoonImageService.addWebtoonImage(webtoonImage);
        System.out.println(webtoonImage1);
    }

    @Test
    public void 이미지_이미지아이디로가져오기(){
        WebtoonImage webtoonImage2 = webtoonImageService.getWebtoonImage(1L);
        System.out.println(webtoonImage2);
    }

}

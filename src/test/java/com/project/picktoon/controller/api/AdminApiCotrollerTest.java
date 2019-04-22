package com.project.picktoon.controller.api;

import com.project.picktoon.controller.AdminController;
import com.project.picktoon.dto.LoadWebtoonLink;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminApiCotrollerTest {
    @Autowired
    AdminApiControllor adminApiController;

    @Test
    public void 크롤링테스트() throws Exception{
        LoadWebtoonLink loadWebtoonLink = new LoadWebtoonLink();
        loadWebtoonLink.setLink("https://comic.naver.com/webtoon/list.nhn?titleId=318995&week=fri");
        System.out.println(adminApiController.loadWebtoonNaver(loadWebtoonLink).toString());

    }
}

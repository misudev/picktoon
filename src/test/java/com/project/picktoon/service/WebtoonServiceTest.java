package com.project.picktoon.service;

import com.project.picktoon.domain.Webtoon;
import com.project.picktoon.service.impl.WebtoonServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class WebtoonServiceTest {

    @Autowired
    WebtoonService webtoonService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void 웹툰추가() throws Exception{
        Webtoon webtoon = new Webtoon();

    }
}
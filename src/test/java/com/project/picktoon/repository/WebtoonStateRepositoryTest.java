package com.project.picktoon.repository;

import com.project.picktoon.domain.WebtoonState;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WebtoonStateRepositoryTest {
    @Autowired
    WebtoonStateRepository webtoonStateRepository;

    @Before
    public void init() throws Exception {
    }

    @Test
    @Rollback(false)
    public void updateWebtoon() throws Exception {
        WebtoonState webtoonState = new WebtoonState();
        webtoonState = webtoonStateRepository.findById(1L).get();
        webtoonState.setUpdatedDate(new Date());
        webtoonState.setTotalCount("100화");
        webtoonState = webtoonStateRepository.findById(1L).get();
        System.out.println(webtoonState);
    }

    @After
    public void tearDown() throws Exception {
    }



}
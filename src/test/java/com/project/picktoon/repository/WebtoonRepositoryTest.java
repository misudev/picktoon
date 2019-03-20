package com.project.picktoon.repository;

import com.project.picktoon.domain.Webtoon;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
public class WebtoonRepositoryTest {
    @Autowired
    WebtoonRepository webtoonRepository;

    @Test
    public void initTest(){

    }

    @Test
    public void getAlls(){
        List<Webtoon> webtoons = webtoonRepository.findAll();
        for(Webtoon w : webtoons)
            System.out.println(w.toString());
    }


}
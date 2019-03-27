package com.project.picktoon.repository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class NewWebtoonRepositoryTest {
    @Autowired
    NewWebtoonRepository newWebtoonRepository;

//    @Before
//    public void initTest(){
//        NewWebtoon newWebtoons = newWebtoonRepository.getOne(1);
//        System.out.println(newWebtoons.toString());
//    }
//
//
//    @Test
//    public void updateNewWebtoon() throws Exception{
//        newWebtoonRepository.updateNewwebtoon(5L, 1);
//        System.out.println(newWebtoonRepository.getOne(1).toString());
//    }
}

package com.project.picktoon.repository;


import com.project.picktoon.domain.NewWebtoon;
import com.project.picktoon.domain.Webtoon;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

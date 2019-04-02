package com.project.picktoon.repository;

import com.project.picktoon.domain.NewWebtoon;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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

    @Test
    public void getNewWebtoons() throws Exception{
        List<NewWebtoon> newWebtoons = newWebtoonRepository.getNewWebtoons();
        for(NewWebtoon n : newWebtoons) {
            System.out.println(n);
        }
    }
}

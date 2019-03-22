package com.project.picktoon.repository;

import com.project.picktoon.domain.MyWebtoon;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MyWebtoonRepositoryTest {
    @Autowired
    MyWebtoonRepository myWebtoonRepository;

//    @Query("SELECT m FROM MyWebtoon m Join FETCH m.webtoon w WHERE m.userId = :userId ORDER BY w.title ASC")
//    public List<MyWebtoon> getMyWebToons(@Param("userId")Long userId, @Param("orderType")String orderType);

    @Test
    public void initTest(){

    }

    @Test
    public void getMyWebtoon1() throws Exception{
        List<MyWebtoon> myWebtoons = myWebtoonRepository.getMyWebToonsByTitleAsc(1L);
        for(MyWebtoon w : myWebtoons){
            System.out.println(w.toString());
        }

    }

    @Test
    public void getMyWebtoon2() throws Exception{
        List<MyWebtoon> myWebtoons = myWebtoonRepository.getMyWebToonsByTitleDesc(1L);
        for(MyWebtoon w : myWebtoons){
            System.out.println(w.toString());
        }

    }

    @Test
    public void getMyWebtoon3() throws Exception{
        List<MyWebtoon> myWebtoons = myWebtoonRepository.getMyWebToonsByOldest(1L);
        for(MyWebtoon w : myWebtoons){
            System.out.println(w.toString());
        }

    }

    @Test
    public void getMyWebtoon4() throws Exception{
        List<MyWebtoon> myWebtoons = myWebtoonRepository.getMyWebToonsByUpdate(1L);
        for(MyWebtoon w : myWebtoons){
            System.out.println(w.toString());
        }

    }

}

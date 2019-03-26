package com.project.picktoon.repository;

import com.project.picktoon.domain.Keyword;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class KeywordRepositoryTest {
    @Autowired
    KeywordRepository keywordRepository;

//  @Query("SELECT k FROM Keyword k WHERE k.keywordType =:type")
//    public List<Keyword> getKeywordsByType(@Param("type")int type);
//  @Query("SELECT k FROM Keyword k WHERE k.keywordType =:type ORDER BY k.ordering DESC")
//    public List<Keyword> getBestKeywords(@Param("type")int type, Pageable pageable);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getKeywordsByType() throws Exception{
        List<Keyword> keywords = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            // 키워드 타입별로 조회한 후 출력해본다.
            System.out.println("---------type "+i+" ------------");
            keywords = keywordRepository.getKeywordsByType(i);
            for(Keyword k : keywords)
                System.out.println(k);

            System.out.println("----------------------------");
        }


    }

    @Test
    public void getBestKeywords() throws Exception{
        List<Keyword> keywords = new ArrayList<>();
        // 상위 키워드 5개만 가져오도록 한다.
        Pageable pageable = PageRequest.of(0,5);
        keywords = keywordRepository.getBestKeywords(4, pageable);
        for(Keyword k : keywords)
            System.out.println(k);
    }

    @After
    public void tearDown() throws Exception {
    }
}
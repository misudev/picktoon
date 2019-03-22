package com.project.picktoon.repository;

import com.project.picktoon.domain.Webtoon;
import com.project.picktoon.repository.custom.WebtoonRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WebtoonRepository extends JpaRepository<Webtoon, Long>, WebtoonRepositoryCustom {
    @Query("SELECt w FROM Webtoon w INNER JOIN FETCH w.platform  LEFT JOIN FETCH w.keywords WHERE w.id =:id")
    public Webtoon getWebtoon(@Param("id")Long id);

    @Query(value = "SELECT w FROM Webtoon w ORDER BY w.subscription DESC LIMIT 3", nativeQuery = true)
    public List<Webtoon> getBestWebtoons();

    @Query("SELECT w FROM Webtoon w INNER JOIN FETCH w.platform  LEFT JOIN FETCH w.keywords WHERE w.title = :title")
    public Webtoon getWebtoonByTitle(@Param("title")String title);


    // JPQL
    // SELECT distinct w FROM Webtoon w INNER JOIN FETCH w.keywords ORDER BY w.id DESC :element in elements(f.elements)
    // 요일로 조회
    // SELECT distinct w FROM Webtoon w INNER JOIN FETCH w.keywords WHERE :keyword
    // 장르으로 검색
    // SELECT distinct w FROM Item i INNER JOIN FETCH i.category WHERE i.name = :searchStr ORDER BY i.id DESC
    // 키워드으로 검색
    // SELECT distinct w FROM Item i INNER JOIN FETCH i.category WHERE i.description =: searchStr ORDER BY i.id DESC




}

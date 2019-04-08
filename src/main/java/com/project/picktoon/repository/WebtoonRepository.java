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

//    @Query("SELECT w FROM Webtoon w INNER JOIN FETCH w.webtoonState  LEFT JOIN FETCH w.keywords WHERE w.title = :title")
//    public Webtoon getWebtoonByTitle(@Param("title")String title);

    // 구독자 증가
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Webtoon w SET w.subscription = w.subscription + 1 WHERE w.id = :id")
    public void updateWebtoonSubscriptionPlus(@Param("id")Long id);

    // 구독자 감소
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Webtoon w SET w.subscription = w.subscription - 1 WHERE w.id = :id")
    public void updateWebtoonSubscriptionMinus(@Param("id")Long id);

    @Modifying
    @Query("DELETE FROM Webtoon w WHERE w.id = :id")
    public void deleteWebtoonById(@Param("id")Long id);

    public boolean existsById(Long id);



}

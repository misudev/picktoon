
package com.project.picktoon.repository;

import com.project.picktoon.domain.MyWebtoon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MyWebtoonRepository extends JpaRepository<MyWebtoon, Long> {
    @Query("SELECT m FROM MyWebtoon m WHERE m.user.id =:userId AND m.webtoon.id =:webtoonId")
    public MyWebtoon findByUserAndWebtoon(@Param("userId") Long userId, @Param("webtoonId") Long webtoonId);

    //오름차순
    @Query("SELECT m FROM MyWebtoon m INNER JOIN FETCH m.webtoon INNER JOIN FETCH m.user WHERE m.user.id = :userId ORDER BY m.webtoon.title")
    public List<MyWebtoon> getMyWebToonsByTitleAsc(@Param("userId")Long userId);

    //내림차순
    @Query("SELECT m FROM MyWebtoon m INNER JOIN FETCH  m.webtoon INNER JOIN FETCH m.user WHERE m.user.id = :userId ORDER BY m.webtoon.title DESC")
    public List<MyWebtoon> getMyWebToonsByTitleDesc(@Param("userId")Long userId);

    //업데이트 오름차순 (오래된순)
    @Query("SELECT m FROM MyWebtoon m INNER JOIN FETCH m.webtoon INNER JOIN FETCH m.user WHERE m.user.id = :userId ORDER BY m.webtoon.updatedDate")
    public List<MyWebtoon> getMyWebToonsByOldest(@Param("userId")Long userId);

    //업데이트 내림차순 (최신순)
    @Query("SELECT m FROM MyWebtoon m INNER JOIN FETCH m.webtoon INNER JOIN FETCH m.user  WHERE m.user.id = :userId ORDER BY m.webtoon.updatedDate DESC")
    public List<MyWebtoon> getMyWebToonsByUpdate(@Param("userId")Long userID);

    @Modifying
    @Query("DELETE FROM MyWebtoon m WHERE m.id = :id")
    public void deleteMyWebtoonById(@Param("id")Long id);

    @Query("SELECT m FROM MyWebtoon m INNER JOIN FETCH m.webtoon INNER JOIN FETCH m.user  WHERE m.user.id =:userId AND m.webtoon.id =:webtoonId")
    public MyWebtoon getMyWebtoonByUserAndWebtoon(@Param("userId") Long userId , @Param("webtoonId")Long webtoonId);

    @Query("SELECT m FROM MyWebtoon m INNER JOIN FETCH m.webtoon INNER JOIN FETCH m.user WHERE m.user.id =:userId AND m.webtoon.updateState = 1")
    public List<MyWebtoon> getMyWebtoonByUpdateState(@Param("userId") Long userId);
}

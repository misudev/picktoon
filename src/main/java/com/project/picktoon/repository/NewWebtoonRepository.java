package com.project.picktoon.repository;

import com.project.picktoon.domain.NewWebtoon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewWebtoonRepository extends JpaRepository<NewWebtoon, Integer> {

//    @Modifying
//    @Query("UPDATE NewWebtoon n SET n.webtoon.id =:webtoonId WHERE n.id =:id")
//    public void updateNewwebtoon(@Param("webtoonId") Long webtoonId , @Param("id") int id);
}

package com.project.picktoon.repository;

import com.project.picktoon.domain.Keyword;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {
    @Query("SELECT k FROM Keyword k WHERE k.keywordType =:type")
    public List<Keyword> getKeywordsByType(@Param("type")int type);

    @Query("SELECT k FROM Keyword k WHERE k.keywordType =:type ORDER BY k.ordering DESC")
    public List<Keyword> getBestKeywords(@Param("type")int type, Pageable pageable);

    @Query("SELECT k FROM Keyword k WHERE k.keywordType = 2 AND k.keywordValue =:value")
    public Keyword getAuthorByName(@Param("value")String name);
}

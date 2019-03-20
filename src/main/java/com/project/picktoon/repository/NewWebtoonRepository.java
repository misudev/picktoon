package com.project.picktoon.repository;

import com.project.picktoon.domain.NewWebtoon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewWebtoonRepository extends JpaRepository<NewWebtoon, Integer> {
}

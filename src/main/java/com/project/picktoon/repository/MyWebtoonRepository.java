package com.project.picktoon.repository;

import com.project.picktoon.domain.MyWebtoon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyWebtoonRepository extends JpaRepository<MyWebtoon, Long> {
}

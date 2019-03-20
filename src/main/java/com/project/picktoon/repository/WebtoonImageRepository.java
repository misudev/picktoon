package com.project.picktoon.repository;

import com.project.picktoon.domain.WebtoonImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebtoonImageRepository extends JpaRepository<WebtoonImage, Long> {
}

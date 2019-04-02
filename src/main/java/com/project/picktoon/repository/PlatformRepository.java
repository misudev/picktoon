package com.project.picktoon.repository;

import com.project.picktoon.domain.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlatformRepository extends JpaRepository<Platform, Integer> {
    public Platform findByPlatformName(String name);
}

package com.project.picktoon.service;

import com.project.picktoon.domain.Platform;

import java.util.List;

public interface PlatformService {
    public Platform getPlatformById(int id);
    public Platform getPlatformByPlatformName(String name);
    public Platform addPlatform(Platform platform);
    public void deletePlatform(int id);
    public List<Platform> getAllPlatforms();
}

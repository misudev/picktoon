package com.project.picktoon.service;

import com.project.picktoon.domain.Platform;

public interface PlatformService {
    public Platform addPlatform(Platform platform);
    public void deletePlatform(int id);
}

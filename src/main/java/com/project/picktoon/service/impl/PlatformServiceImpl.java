package com.project.picktoon.service.impl;

import com.project.picktoon.domain.Platform;
import com.project.picktoon.repository.PlatformRepository;
import com.project.picktoon.service.PlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlatformServiceImpl implements PlatformService {
    public final PlatformRepository platformRepository;
    @Override
    public Platform addPlatform(Platform platform) {
        return platformRepository.save(platform);
    }

    @Override
    public void deletePlatform(int id) {
        platformRepository.deleteById(id);
    }
}

package com.project.picktoon.service.impl;

import com.project.picktoon.domain.Platform;
import com.project.picktoon.repository.PlatformRepository;
import com.project.picktoon.service.PlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PlatformServiceImpl implements PlatformService {
    public final PlatformRepository platformRepository;

    @Override
    @Transactional(readOnly = true)
    public Platform getPlatformById(int id) {
        return platformRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Platform addPlatform(Platform platform) {
        return platformRepository.save(platform);
    }

    @Override
    @Transactional
    public void deletePlatform(int id) {
        platformRepository.deleteById(id);
    }
}

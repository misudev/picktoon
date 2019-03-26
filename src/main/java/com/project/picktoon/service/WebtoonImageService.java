package com.project.picktoon.service;

import com.project.picktoon.domain.WebtoonImage;

public interface WebtoonImageService {
    public WebtoonImage addWebtoonImage(WebtoonImage webtoonImage, Long webtoonId);
    public WebtoonImage getWebtoonImage(Long webtoonImageId);
}

package com.project.picktoon.service;

import com.project.picktoon.domain.WebtoonImage;

public interface WebtoonImageService {
    public WebtoonImage addWebtoonImage(WebtoonImage webtoonImage);
    public WebtoonImage getWebtoonImage(Long webtoonImageId);
}

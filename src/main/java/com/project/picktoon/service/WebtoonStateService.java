package com.project.picktoon.service;

import com.project.picktoon.domain.WebtoonState;

public interface WebtoonStateService {
    public WebtoonState getWebtoonStateById(Long id);
    public WebtoonState getWebtoonStateByWebtoonId(Long webtoonId);
    public WebtoonState addWebtoonState(Long webtoonId, WebtoonState webtoonState);
    public void updateWebtoonState(WebtoonState webtoonState);
}

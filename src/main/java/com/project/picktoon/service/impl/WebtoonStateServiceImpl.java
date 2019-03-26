package com.project.picktoon.service.impl;

import com.project.picktoon.domain.WebtoonState;
import com.project.picktoon.repository.WebtoonRepository;
import com.project.picktoon.repository.WebtoonStateRepository;
import com.project.picktoon.service.WebtoonStateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WebtoonStateServiceImpl implements WebtoonStateService {
    public final WebtoonStateRepository webtoonStateRepository;
    public final WebtoonRepository webtoonRepository;

    @Override
    @Transactional(readOnly = true)
    public WebtoonState getWebtoonStateById(Long id) {
        return webtoonStateRepository.findById(id).get();
    }

    @Override
    @Transactional
    public WebtoonState addWebtoonState(Long webtoonId, WebtoonState webtoonState) {
        webtoonState.setWebtoon(webtoonRepository.getWebtoon(webtoonId));
        return webtoonStateRepository.save(webtoonState);
    }

    @Override
    @Transactional
    public void updateWebtoonState(WebtoonState webtoonState) {
        WebtoonState beforeState = webtoonStateRepository.findById(webtoonState.getId()).get();
        beforeState.setUpdateState(webtoonState.getUpdateState());
        beforeState.setTotalCount(webtoonState.getTotalCount());
        beforeState.setUpdatedDate(webtoonState.getUpdatedDate());
    }
}

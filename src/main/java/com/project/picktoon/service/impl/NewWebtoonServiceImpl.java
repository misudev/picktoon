package com.project.picktoon.service.impl;

import com.project.picktoon.domain.NewWebtoon;
import com.project.picktoon.repository.NewWebtoonRepository;
import com.project.picktoon.repository.WebtoonRepository;
import com.project.picktoon.service.NewWebtoonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NewWebtoonServiceImpl implements NewWebtoonService {
    public final NewWebtoonRepository newWebtoonRepository;
    public final WebtoonRepository webtoonRepository;

    @Override
    @Transactional
    public NewWebtoon updateNewWebtoon(Long webtoonId, int ordering) {
        NewWebtoon newWebtoon = new NewWebtoon();
        newWebtoon.setWebtoon(webtoonRepository.getWebtoon(webtoonId));
        newWebtoon.setOrdering(ordering);
        return newWebtoonRepository.save(newWebtoon);
    }
}

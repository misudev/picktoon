package com.project.picktoon.service.impl;

import com.project.picktoon.domain.NewWebtoon;
import com.project.picktoon.domain.Webtoon;
import com.project.picktoon.repository.NewWebtoonRepository;
import com.project.picktoon.repository.WebtoonRepository;
import com.project.picktoon.service.NewWebtoonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NewWebtoonServiceImpl implements NewWebtoonService {
    public final NewWebtoonRepository newWebtoonRepository;
    public final WebtoonRepository webtoonRepository;

    @Override
    @Transactional(readOnly = true)
    public NewWebtoon getNewWebtoonById(int id) {
        return newWebtoonRepository.findById(id).get();
    }

    @Override
    @Transactional(readOnly = true)
    public List<NewWebtoon> getNewWebtoons() {
        return newWebtoonRepository.getNewWebtoons();
    }

    @Override
    @Transactional
    public void updateNewWebtoon(NewWebtoon newWebtoon) {
        newWebtoonRepository.save(newWebtoon);
    }

    //    @Override
//    @Transactional
//    public NewWebtoon updateNewWebtoon(int id, Long webtoonId, int ordering) {
//        Optional<NewWebtoon> maybeNewWebtoon = newWebtoonRepository.findById(id);
//        if (!maybeNewWebtoon.isPresent()) {
//            NewWebtoon newNewWebtoon = new NewWebtoon();
//            newNewWebtoon.setId(id);
//            newNewWebtoon.setWebtoon(webtoonRepository.getWebtoon(webtoonId));
//            newNewWebtoon.setOrdering(ordering);
//            return newWebtoonRepository.save(newNewWebtoon);
//        }
//        NewWebtoon newWebtoon = maybeNewWebtoon.get();
//        newWebtoon.setWebtoon(webtoonRepository.getWebtoon(webtoonId));
//        newWebtoon.setOrdering(ordering);
//        return newWebtoon;
//    }
}

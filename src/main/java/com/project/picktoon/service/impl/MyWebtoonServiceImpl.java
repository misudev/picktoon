package com.project.picktoon.service.impl;

import com.project.picktoon.domain.MyWebtoon;
import com.project.picktoon.domain.User;
import com.project.picktoon.domain.Webtoon;
import com.project.picktoon.repository.MyWebtoonRepository;
import com.project.picktoon.repository.UserRepository;
import com.project.picktoon.repository.WebtoonRepository;
import com.project.picktoon.service.MyWebtoonService;
import com.project.picktoon.util.OrderType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyWebtoonServiceImpl implements MyWebtoonService {
    public final MyWebtoonRepository myWebtoonRepository;
    public final WebtoonRepository webtoonRepository;
    public final UserRepository userRepository;

    @Override
    @Transactional
    public MyWebtoon addMyWebtoon(Long userId, Long webtoonId) {
        //추가할 NewWebtoon 객체 생성.
        MyWebtoon newMyWebtoon = new MyWebtoon();

        // userId , webtoonId 로 MyWebtoon 존재하는지 확인
        MyWebtoon checkMyWebtoon = myWebtoonRepository.findByUserAndWebtoon(userId,webtoonId);
        if(checkMyWebtoon != null)
            return checkMyWebtoon;

        newMyWebtoon.setUser(userRepository.findById(userId).get());
        newMyWebtoon.setWebtoon(webtoonRepository.getWebtoon(webtoonId));
        //구독자 수 증가.
        webtoonRepository.updateWebtoonSubscriptionPlus(webtoonId);

        return myWebtoonRepository.save(newMyWebtoon);
    }

    @Override
    @Transactional
    public void changeAlarm(Long myWebtoonId) {
        MyWebtoon myWebtoon = myWebtoonRepository.findById(myWebtoonId).get();
        myWebtoon.setAlarm(myWebtoon.getAlarm()? false: true);

    }

    @Override
    @Transactional
    public void deleteMyWebtoon(Long myWebtoonId) {
        Long webtoonId = myWebtoonRepository.getOne(myWebtoonId).getWebtoon().getId();
        myWebtoonRepository.deleteById(myWebtoonId);
        myWebtoonRepository.flush();
        //구독자수 감소.
        webtoonRepository.updateWebtoonSubscriptionMinus(webtoonId);
//        MyWebtoon myWebtoon = myWebtoonRepository.findById(myWebtoonId).get();
//        Long webtoonId = myWebtoon.getWebtoon().getId();
//        myWebtoonRepository.delete(myWebtoon);
//        //구독자수 감소.
//        webtoonRepository.updateWebtoonSubscriptionMinus(webtoonId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MyWebtoon> getMyWebtoons(Long userId, int orderType) {
        // 정렬 타입에 따라 결과 리턴.
        if(orderType == OrderType.ORDER_TITLE_ASC)
            return myWebtoonRepository.getMyWebToonsByTitleAsc(userId);
        else if(orderType == OrderType.ORDER_TITLE_DESC)
            return myWebtoonRepository.getMyWebToonsByTitleDesc(userId);
        else if(orderType == OrderType.ORDER_UPDATE_ASC)
            return myWebtoonRepository.getMyWebToonsByOldest(userId);
        else if(orderType == OrderType.ORDER_UPDATE_DESC)
            return myWebtoonRepository.getMyWebToonsByUpdate(userId);
        else
            return null;
    }

    @Override
    @Transactional(readOnly = true)
    public MyWebtoon getMyWebtoonById(Long myWebtoonId) {
        return myWebtoonRepository.findById(myWebtoonId).orElse(null);
    }
}

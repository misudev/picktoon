package com.project.picktoon.controller;

import com.project.picktoon.domain.Webtoon;
import com.project.picktoon.service.WebtoonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
@Log
@RequiredArgsConstructor
public class WebtoonTaskScheduler {
    private final WebtoonService webtoonService;

    private Map<Long, Webtoon> targetWebtoons = new HashMap<>();
    private Map<Long, Webtoon> remainWebtoons = new HashMap<>();

    @Scheduled(cron= "0 45 23 * * *")
    public void renewTargetWebtoons(){
        Calendar calendar = Calendar.getInstance();
        long nowDate = (long)calendar.get(Calendar.DAY_OF_WEEK);

        remainWebtoons.putAll(targetWebtoons);
        targetWebtoons = new HashMap<>();

        //다음날 연재일인 웹툰을 가져온다...
        log.info("now date : "+nowDate);
        List<Webtoon> webtoons = webtoonService.getUpdateCheckWebtoon(nowDate);
        for(Webtoon w : webtoons){
            targetWebtoons.put(w.getId() , w);
        }
        //targetWebtoons.addAll(webtoonService.getUpdateCheckWebtoon(nowDate)); // 1(월) ~ 7(일)
        log.info("targetWebtoons : " + targetWebtoons.size());

        for(Long key : targetWebtoons.keySet())
            log.info("webtoon title : "+ targetWebtoons.get(key).getTitle());

    }

    // 10분 마다 체크 !!
    @Scheduled(cron= "0 0/10 * * * *" )
    public void checkUpdate() {
       Iterator<Long> it =  targetWebtoons.keySet().iterator();

       while(it.hasNext()){
           try {
               Long id = it.next();
               Webtoon webtoon = targetWebtoons.get(id);
               //웹에서 내용을 가져온다.
               Document doc = Jsoup.connect(webtoon.getLink()).timeout(5000).get();

               String newUpdateDateStr = doc.select("td.num").first().text();    // 업데이트 날짜
               String newCount = doc.select("td.title > a").first().text();   // 최신 화
               log.info("checkwebtoon title : "+ webtoon.getTitle());
               log.info("new update date : " + newUpdateDateStr);
               if(!newCount.equals(webtoon.getTotalCount())){
                   // 총 화수 변경
                   webtoon.setTotalCount(newCount);
                   // 웹툰 업데이트 날짜 변경
                   webtoon.setUpdatedDate(new Date());
                   // 웹툰 업데이트 상태 변경
                   webtoon.setUpdateState(true);
                   // 저장한 후 삭제..
                   webtoonService.updateWebtoon(webtoon);
                   it.remove();
                   log.info("웹툰 업데이트 완료 : "+ webtoon.getTitle());
               }

           }catch (Exception ex){
               ex.printStackTrace();
           }
       }

    }
}

package com.project.picktoon.crawling;

import lombok.extern.java.Log;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

//http://webtoon.daum.net/data/pc/webtoon/view/savior --> json 으로 가져오자..
@Log
@Component
public class DaumWebtoonCrawler{
    public void getWebtoonList() {
        try {
            //웹에서 내용을 가져온다.
            log.info("::getWebtoonList");
            String webtoonFridayLink = "http://webtoon.daum.net/#day=fri&tab=day";
            Document doc = Jsoup.connect(webtoonFridayLink).timeout(5000).get();

            log.info(doc.select("ul#dayList1").text());
            Elements links = doc.select("ul#dayList1 > li > a");

            for (Element e : links) {
                log.info("webtoon link : " + e.text());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

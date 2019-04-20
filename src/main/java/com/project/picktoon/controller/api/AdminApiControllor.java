package com.project.picktoon.controller.api;

import com.project.picktoon.dto.LoadWebtoonData;
import com.project.picktoon.dto.LoadWebtoonLink;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/admin")
public class AdminApiControllor {

    @PostMapping("/loadwebtoon")
    public LoadWebtoonData loadWebtoonNaver(@RequestBody LoadWebtoonLink loadWebtoonLink){
        try {
            //웹에서 내용을 가져온다.
            System.out.println(loadWebtoonLink.getLink());
            Document doc = Jsoup.connect(loadWebtoonLink.getLink()).timeout(5000).get();

            //내용 중에서 원하는 부분을 가져온다.
            Elements titleEl = doc.select(".title");
            Elements authorEls = doc.select(".nm");
            Elements descriptionEl = doc.select(".info_cont");
            Element updatedDateEl = doc.select(".if1").first();
            Element countEl = doc.select(".toon_name").first();

            LoadWebtoonData loadWebtoonData = new LoadWebtoonData();
            loadWebtoonData.setLink(loadWebtoonLink.getLink());
            // 원하는 부분은 Elements형태로 되어 있으므로 이를 String 형태로 바꾸어 준다.
            loadWebtoonData.setTitle(titleEl.text());

            for(Element a :authorEls){
                loadWebtoonData.addAuthor(a.text());
            }

            loadWebtoonData.setDescription(descriptionEl.text());

            loadWebtoonData.setUpdatedDate(updatedDateEl.text());
            loadWebtoonData.setCount(countEl.text());

            return loadWebtoonData;

        } catch (IOException e) { //Jsoup의 connect 부분에서 IOException 오류가 날 수 있으므로 사용한다.

            e.printStackTrace();
            return null;
        }
    }
}

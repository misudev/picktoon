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
            Document doc = Jsoup.connect(loadWebtoonLink.getLink()).timeout(5000).get();

            //내용 중에서 원하는 부분을 가져온다.
//            Elements titleEl = doc.select(".title");
//            Elements authorEls = doc.select(".nm");
//            Elements descriptionEl = doc.select(".info_cont");
//            Element updatedDateEl = doc.select(".if1").first();
//            Element countEl = doc.select(".toon_name").first();

            String title = doc.select(".detail h2").first().ownText();  // 제목
            Elements authorEls = doc.select(".wrt_nm"); // 작가
            String description = doc.select(".detail p").text();    // 설명
            String updateDate = doc.select("td.num").first().text();    // 업데이트 날짜
            String count = doc.select("td.title > a").first().text();   // 최신 화
            String imgUrl = doc.select(".thumb img").first().getElementsByAttribute("src").attr("src");

            LoadWebtoonData loadWebtoonData = new LoadWebtoonData();
            loadWebtoonData.setTitle(title);
            loadWebtoonData.setLink(loadWebtoonLink.getLink());
            // 원하는 부분은 Elements형태로 되어 있으므로 이를 String 형태로 바꾸어 준다.

            for(Element a :authorEls){
                loadWebtoonData.addAuthor(a.text());
            }


            loadWebtoonData.setDescription(description);
            loadWebtoonData.setUpdatedDate(updateDate);
            loadWebtoonData.setCount(count);
            loadWebtoonData.setImgUrl(imgUrl);

            return loadWebtoonData;

        } catch (IOException e) { //Jsoup의 connect 부분에서 IOException 오류가 날 수 있으므로 사용한다.

            e.printStackTrace();
            return null;
        }
    }
}

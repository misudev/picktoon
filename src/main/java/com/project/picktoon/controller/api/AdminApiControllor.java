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
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api/admin")
public class AdminApiControllor {

    @PostMapping("/loadwebtoon")
    public LoadWebtoonData loadWebtoonNaver(@RequestBody LoadWebtoonLink loadWebtoonLink){
        try {
            //웹에서 내용을 가져온다.
            Document doc = Jsoup.connect(loadWebtoonLink.getLink()).timeout(5000).get();

            //내용 중에서 원하는 부분을 가져온다.
            String title = doc.select(".detail h2").first().ownText();  // 제목
            String authorsStr = doc.select(".wrt_nm").text(); // 작가
            String description = doc.select(".detail p").text();    // 설명
            String updateDateStr = doc.select("td.num").first().text();    // 업데이트 날짜
            String count = doc.select("td.title > a").first().text();   // 최신 화
            String imgUrl = doc.select(".thumb img").first().getElementsByAttribute("src").attr("src");

            LoadWebtoonData loadWebtoonData = new LoadWebtoonData();
            loadWebtoonData.setTitle(title);
            loadWebtoonData.setLink(loadWebtoonLink.getLink());

            //작가 -- 네이버는 작가가 2명일 경우 /로 구분한다.
            authorsStr = authorsStr.replace(" ", "");
            String[] authors = authorsStr.split("/");

            for(String a : authors){
                loadWebtoonData.addAuthor(a);
            }

            loadWebtoonData.setDescription(description);
            loadWebtoonData.setUpdatedDate(updateDateStr);
            loadWebtoonData.setCount(count);
            loadWebtoonData.setImgUrl(imgUrl);

            return loadWebtoonData;

        } catch (IOException e) { //Jsoup의 connect 부분에서 IOException 오류가 날 수 있으므로 사용한다.

            e.printStackTrace();
            return null;
        }
    }
}

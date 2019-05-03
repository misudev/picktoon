package com.project.picktoon.crawling;


import lombok.extern.java.Log;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class SeleniumCrawlingTest {
    private WebDriver driver;

    @Before
    public void init(){
        // 크롬 버전  : 74
        //System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        String classpathRelativeLocation = "driver/chromedriver";
        URL url = this.getClass().getClassLoader().getResource(classpathRelativeLocation);
        File file = new File(url.getFile());
        ChromeDriverService.Builder bldr = (new ChromeDriverService.Builder())
                .usingDriverExecutable(file)
                .usingAnyFreePort();
        driver = new ChromeDriver(bldr.build());
    }

    @After
    public void after() throws Exception{
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void 크롤링테스트() {
        driver.get("https://www.lezhin.com/ko/comic/wind");
        //List<WebElement> episodeSeq = driver.findElements(By.className("episode-seq"));
        String title = driver.findElement(By.className("title")).getText();
        String artist = driver.findElement(By.className("artist")).getText().substring(4);
        String genre = driver.findElement(By.className("genre")).getText().substring(4);

        log.info("title : "+ title);
        log.info("artist : "+ artist);
        log.info("genre : "+ genre);

        WebElement element = driver.findElement(By.id("comic-episode-list"));
        List<WebElement> li  = element.findElements(By.tagName("li"));
//      List<WebElement> li = driver.findElements(By.xpath("//ul[@id='comic-episode-list']/li[@class='is-hide']"));
//      List<WebElement> li = driver.findElements(By.className("is-hide"));
//      로그인 버튼 클릭
//      webElement = driver.findElement(By.id("loginSubmit"));
//      webElement.submit();

        log.info("list 사이즈 : "+ li.size());
        SimpleDateFormat format = new SimpleDateFormat("yy.MM.dd");
        Date day = null;
        Date now = new Date();
        int index = 0;
        WebElement webElement = li.get(0);

        for(int i = 1 ; i <li.size(); i++){
            WebElement w = li.get(i);
            try{
                day = format.parse(w.findElement(By.className("free-date")).getText());
            }catch (Exception ex){
                ex.printStackTrace();
            }
            if(day.after(now)){
                // 0인 경우.. 예외처리.
                webElement = li.get(i-1);
                index = i-1;
                break;
            }

        }
        String updatedDate = webElement.findElement(By.className("free-date")).getText();
        String count = webElement.findElement(By.className("episode-name")).getText();
        log.info("updatedDate " + updatedDate);
        log.info("count "+count);

//        for(WebElement w : episodeSeq){
//            String episodeName = w.findElement(By.className("episode-name")).getText();
//            String episodeDate = w.findElement(By.className("free-date")).getText();
//            log.info("몇화? : "+ episodeName + "  업데이트 날짜? : " + episodeDate);
//        }
    }
}

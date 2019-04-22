package com.project.picktoon.controller;

import com.project.picktoon.domain.Keyword;
import com.project.picktoon.domain.Platform;
import com.project.picktoon.domain.Webtoon;
import com.project.picktoon.domain.WebtoonImage;
import com.project.picktoon.service.KeywordService;
import com.project.picktoon.service.PlatformService;
import com.project.picktoon.service.WebtoonImageService;
import com.project.picktoon.service.WebtoonService;
import com.project.picktoon.util.KeywordType;
import com.project.picktoon.util.SeeAge;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final KeywordService keywordService;
    private final PlatformService platformService;
    private final WebtoonImageService webtoonImageService;
    private final WebtoonService webtoonService;

    @GetMapping("/regist")
    public String regist(Model model){
        List<Keyword> days = keywordService.getKeywordsByType(KeywordType.KEYWORD_DAY);
        List<Keyword> genres = keywordService.getKeywordsByType(KeywordType.KEYWORD_GENRE);
        List<Keyword> keywords = keywordService.getKeywordsByType(KeywordType.KEYWORD_KEYWORD);
        List<Platform> platforms = platformService.getAllPlatforms();

        model.addAttribute("days", days);
        model.addAttribute("genres", genres);
        model.addAttribute("keywords", keywords);
        model.addAttribute("platforms", platforms);

        return "admin/regist";
    }

    @GetMapping("/regist2")
    public String regist2(Model model){
        List<Keyword> days = keywordService.getKeywordsByType(KeywordType.KEYWORD_DAY);
        List<Keyword> genres = keywordService.getKeywordsByType(KeywordType.KEYWORD_GENRE);
        List<Keyword> keywords = keywordService.getKeywordsByType(KeywordType.KEYWORD_KEYWORD);
        List<Platform> platforms = platformService.getAllPlatforms();

        model.addAttribute("days", days);
        model.addAttribute("genres", genres);
        model.addAttribute("keywords", keywords);
        model.addAttribute("platforms", platforms);

        return "admin/registcrawling";
    }

    @PostMapping("/regist")
    public String regist(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "author") String[] authors,
	        @RequestParam(name= "day") Long[] days,
            @RequestParam(name= "multicheckbox_genre[]") Long[] genres,
            @RequestParam(name= "multicheckbox_keyword[]") Long[] keywordIds,
            @RequestParam(name = "link") String link,
            @RequestParam(name = "count") String count,
            @RequestParam(name = "seeage") int seeage,
            @RequestParam(name = "platform") int platform,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "image") MultipartFile[] images,
            @RequestParam(name = "imgurl", required = false)String imgUrl
    ){
        Assert.hasText(title, "제목을 입력하세요.");
        Assert.notEmpty(authors, "작가를 입력하세요.");
        Assert.hasText(link, "링크를 입력하세요.");

        Webtoon webtoon = new Webtoon();
        webtoon.setTitle(title);
        webtoon.setLink(link);
        webtoon.setTotalCount(count);
        webtoon.setSeeAge(SeeAge.SEEAGES[seeage]);
        webtoon.setPlatform(platformService.getPlatformById(platform));
        webtoon.setDescription(description);

        List<Keyword> keywords = new ArrayList<>();

        // 작가
        for(String a : authors){
            Keyword existAuthor = keywordService.getAuthorByName(a);
            if(existAuthor == null){
                Keyword author = new Keyword();
                author.setKeywordType(KeywordType.KEYWORD_AUTHOR);
                author.setKeywordValue(a);
                author = keywordService.addKeyword(author);
                keywords.add(author);
            }else{
                keywords.add(existAuthor);
            }

        }

        if(days != null)
            keywords.addAll(returnKeywords(days));
        if(genres != null)
            keywords.addAll(returnKeywords(genres));
        if(keywordIds != null)
            keywords.addAll(returnKeywords(keywordIds));

        webtoon.setKeywords(keywords);

        if(imgUrl == null) {
            if (images != null && images.length > 0) {
                for (MultipartFile image : images) {
                    if (!image.isEmpty()) {
                        WebtoonImage imageFile = new WebtoonImage();
                        imageFile.setLength(image.getSize());
                        imageFile.setMimeType(image.getContentType());
                        imageFile.setName(image.getOriginalFilename());
                        // 파일 저장
                        // /tmp/2019/2/12/123421-12341234-12341234-123423142
                        String saveFileName = saveFile(image);

                        imageFile.setSaveFileName(saveFileName); // save되는 파일명
                        webtoon.addWebtoonImage(imageFile);
                    }
                }
            }
        }else{
            WebtoonImage imageFile = saveFileFromUrl(imgUrl);
            imageFile.setName(title);
            imageFile.setMimeType("image/jpeg");

            webtoon.addWebtoonImage(imageFile);

        }

        webtoonService.addWebtoon(webtoon);
        return "redirect:/main";
    }

    private String saveFile(MultipartFile image){
        String dir = "imagefile/webtoon/";
        Calendar calendar = Calendar.getInstance();
        dir = dir + calendar.get(Calendar.YEAR);
        dir = dir + "/";
        dir = dir + (calendar.get(Calendar.MONTH) + 1);
        dir = dir + "/";
        dir = dir + calendar.get(Calendar.DAY_OF_MONTH);
        dir = dir + "/";
        File dirFile = new File(dir);
        dirFile.mkdirs(); // 디렉토리가 없을 경우 만든다. 퍼미션이 없으면 생성안될 수 있다.
        dir = dir + UUID.randomUUID().toString();

        try(FileOutputStream fos = new FileOutputStream(dir);
            InputStream in = image.getInputStream()
        ){
            byte[] buffer = new byte[1024];
            int readCount = 0;
            while((readCount = in.read(buffer)) != -1){
                fos.write(buffer, 0, readCount);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return dir;
    }
    // 크롤링한 이미지 저장.
    private WebtoonImage saveFileFromUrl(String url){
        String dir = "imagefile/webtoon/";
        WebtoonImage webtoonImage = new WebtoonImage();
        Calendar calendar = Calendar.getInstance();
        dir = dir + calendar.get(Calendar.YEAR);
        dir = dir + "/";
        dir = dir + (calendar.get(Calendar.MONTH) + 1);
        dir = dir + "/";
        dir = dir + calendar.get(Calendar.DAY_OF_MONTH);
        dir = dir + "/";
        File dirFile = new File(dir);
        dirFile.mkdirs(); // 디렉토리가 없을 경우 만든다. 퍼미션이 없으면 생성안될 수 있다.
        dir = dir + UUID.randomUUID().toString();
        try{
            URL imgUrl = new URL(url);
            BufferedImage jpg = ImageIO.read(imgUrl);
            File file = new File(dir+".jpg");
            ImageIO.write(jpg, "jpg", file);
            System.out.println("file length : "+file.length());

            webtoonImage.setSaveFileName(dir+".jpg");
            webtoonImage.setLength(file.length());

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return webtoonImage;
    }

    private List<Keyword> returnKeywords(Long[] ids){
        List<Keyword> result = new ArrayList<>();
        for(Long id: ids){
            result.add(keywordService.getKeywordById(id));
        }
        return result;
    }

}

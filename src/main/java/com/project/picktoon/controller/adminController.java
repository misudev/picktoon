package com.project.picktoon.controller;

import com.project.picktoon.domain.Keyword;
import com.project.picktoon.domain.Platform;
import com.project.picktoon.service.KeywordService;
import com.project.picktoon.service.PlatformService;
import com.project.picktoon.util.KeywordType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Key;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class adminController {
    private final KeywordService keywordService;
    private final PlatformService platformService;

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
}

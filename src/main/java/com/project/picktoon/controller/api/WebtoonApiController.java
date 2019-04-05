package com.project.picktoon.controller.api;

import com.project.picktoon.domain.Webtoon;
import com.project.picktoon.domain.WebtoonState;
import com.project.picktoon.dto.*;
import com.project.picktoon.service.PlatformService;
import com.project.picktoon.service.WebtoonImageService;
import com.project.picktoon.service.WebtoonService;
import com.project.picktoon.service.WebtoonStateService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/webtoons")
@RequiredArgsConstructor
public class WebtoonApiController {

    private final WebtoonService webtoonService;
    private final WebtoonImageService webtoonImageService;
    private final WebtoonStateService webtoonStateService;
    private final PlatformService platformService;
    private final ModelMapper modelMapper;

    // 웹툰 id로 가져오기 (상세정보 포함)
    @GetMapping("/{webtoonId}")
    public WebtoonDto getWebtoon(@PathVariable Long webtoonId){
        Webtoon webtoon = webtoonService.getWebtoonById(webtoonId);
        WebtoonDto webtoonDto = modelMapper.map(webtoon, WebtoonDto.class);
        return webtoonDto;
    }
    // 웹툰 추가하기
    @PostMapping
    public void addWebtoon(@Valid @RequestBody WebtoonForm webtoonForm){
        Webtoon webtoon = modelMapper.map(webtoonForm, Webtoon.class);
        webtoon.setId(null);
        webtoon.setWebtoonState(webtoonStateService.getWebtoonStateById(webtoonForm.getWebtoonStateId()));
        webtoon.setPlatform(platformService.getPlatformById(webtoonForm.getPlatformId()));
        webtoonService.addWebtoon(webtoon);
    }

    //웹툰 수정하기
    @PutMapping
    public void updateWebtoon(@Valid @RequestBody WebtoonForm webtoonForm){
        Webtoon webtoon = modelMapper.map(webtoonForm, Webtoon.class);
        webtoon.setWebtoonState(webtoonStateService.getWebtoonStateById(webtoonForm.getWebtoonStateId()));
        webtoon.setPlatform(platformService.getPlatformById(webtoonForm.getPlatformId()));
        webtoonService.updateWebtoon(webtoon);
    }

    //웹툰 삭제하기
    @DeleteMapping("/{webtoonId}")
    public void deleteWebtoon(@PathVariable Long webtoonId){
        webtoonService.deleteWebtoon(webtoonId);
    }

    //웹툰 검색
    @GetMapping("/search")
    public List<SearchWebtoonDto> searchWebtoons(@RequestParam(name = "page", required = false, defaultValue = "1") int page,
                                           @RequestParam(name = "key1", required = false) String[] keywords1,
                                           @RequestParam(name = "key2", required = false) String[] keywords2,
                                           @RequestParam(name = "key3", required = false) String[] keywords3,
                                           @RequestParam(name = "key4", required = false) String[] keywords4,
                                           @RequestParam(name = "searchStr", required = false) String searchStr){
        List<SearchKeyword> searchKeywords = new ArrayList<>();

        if(keywords1 != null)
            searchKeywords.addAll(convertToSearchKeyword(1,keywords1));
        if(keywords2 != null)
            searchKeywords.addAll(convertToSearchKeyword(2,keywords2));
        if(keywords3 != null)
            searchKeywords.addAll(convertToSearchKeyword(3,keywords3));
        if(keywords4 != null)
            searchKeywords.addAll(convertToSearchKeyword(4,keywords4));

        List<Webtoon> webtoons =  webtoonService.getWebtoons(searchKeywords, searchStr, page);
        List<SearchWebtoonDto> results = new ArrayList<>();

        for(Webtoon webtoon : webtoons){
            SearchWebtoonDto searchWebtoonDto = modelMapper.map(webtoon, SearchWebtoonDto.class);
            results.add(searchWebtoonDto);
        }
        return results;
    }

    private List<SearchKeyword> convertToSearchKeyword(int keywordType, String[] keywords){
        List<SearchKeyword> result = new ArrayList<>();
        SearchKeyword searchKeyword = new SearchKeyword();
        for(String value : keywords){
            searchKeyword.setKeywordType(keywordType);
            searchKeyword.setKeywordValue(value);
            result.add(searchKeyword);
        }
        return result;
    }


}

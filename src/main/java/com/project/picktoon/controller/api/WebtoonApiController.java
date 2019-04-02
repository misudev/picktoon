package com.project.picktoon.controller.api;

import com.project.picktoon.domain.Webtoon;
import com.project.picktoon.dto.AddWebtoon;
import com.project.picktoon.dto.SearchKeyword;
import com.project.picktoon.dto.SearchWebtoonDto;
import com.project.picktoon.dto.WebtoonDto;
import com.project.picktoon.service.PlatformService;
import com.project.picktoon.service.WebtoonImageService;
import com.project.picktoon.service.WebtoonService;
import com.project.picktoon.service.WebtoonStateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/webtoon")
@RequiredArgsConstructor
public class WebtoonApiController {
//    public List<Webtoon> getWebtoons(List<SearchKeyword> keywords, String searchStr);
//    public Webtoon getWebtoonById(Long id);
//    public List<Webtoon> getBestWebtoons();
//    public Webtoon addWebtoon(Webtoon webtoon);
//    public void updateWebtoon(Webtoon webtoon);
//    public void deleteWebtoon(Long id);
    private final WebtoonService webtoonService;
    private final WebtoonImageService webtoonImageService;
    private final WebtoonStateService webtoonStateService;
    private final PlatformService platformService;

    @GetMapping("/{webtoonId}")
    public WebtoonDto getWebtoon(@PathVariable Long webtoonId){
        WebtoonDto webtoonDto = new WebtoonDto();
        Webtoon webtoon = webtoonService.getWebtoonById(webtoonId);

        webtoonDto.setId(webtoonId);
        webtoonDto.setTitle(webtoon.getTitle());
        webtoonDto.setSeeAge(webtoon.getSeeAge());
        webtoonDto.setDescription(webtoon.getDescription());
        webtoonDto.setLink(webtoon.getLink());
        webtoonDto.setState(webtoon.getState());
        webtoonDto.setPlatformName(webtoon.getPlatform().getPlatformName());
        //webtoonDto.setWebtoonImageId(webtoon.getWebtoonImage().getId());
        webtoonDto.setWebtoonStateId(webtoon.getWebtoonState().getId());

        return webtoonDto;
    }

    @PostMapping
    public void addWebtoon(@RequestBody AddWebtoon webtoonDto){
        //    private Long id;
        //    private String title;
        //    private String state;
        //    private String seeAge;
        //    private String link;
        //    private int subscription;
        //    private String description;
        //    private String platformName;
        //    private Long webtoonImageId;
        //    private Long webtoonStateId;
        Webtoon webtoon = new Webtoon();
        webtoon.setTitle(webtoonDto.getTitle());
        webtoon.setState(webtoonDto.getState());
        webtoon.setSeeAge(webtoonDto.getSeeAge());
        webtoon.setLink(webtoonDto.getLink());
        webtoon.setSubscription(webtoonDto.getSubscription());
        webtoon.setWebtoonImage(webtoonImageService.getWebtoonImage(webtoonDto.getWebtoonImageId()));
        webtoon.setPlatform(platformService.getPlatformById(webtoonDto.getPlatformId()));

        webtoonService.addWebtoon(webtoon);
    }

    @PutMapping()
    public void updateWebtoon(@RequestBody WebtoonDto webtoonDto){
        Webtoon webtoon = new Webtoon();
        webtoon.setId(webtoonDto.getId());
        webtoon.setTitle(webtoonDto.getTitle());
        webtoon.setState(webtoonDto.getState());
        webtoon.setSeeAge(webtoonDto.getSeeAge());
        webtoon.setLink(webtoonDto.getLink());
        webtoon.setSubscription(webtoonDto.getSubscription());
        webtoon.setWebtoonImage(webtoonImageService.getWebtoonImage(webtoonDto.getWebtoonImageId()));
        webtoon.setPlatform(platformService.getPlatformByPlatformName(webtoonDto.getPlatformName()));
        webtoon.setWebtoonState(webtoonStateService.getWebtoonStateById(webtoonDto.getWebtoonStateId()));
        webtoon.setWebtoonImage(webtoonImageService.getWebtoonImage(webtoonDto.getWebtoonImageId()));

        webtoonService.updateWebtoon(webtoon);
    }

    @DeleteMapping("/{webtoonId}")
    public void deleteWebtoon(@PathVariable Long webtoonId){
        webtoonService.deleteWebtoon(webtoonId);
    }

    //웹툰 검색
    // TODO 페이징....
    @PostMapping("/search")
    public List<WebtoonDto> searchWebtoons(@RequestBody SearchWebtoonDto searchForm){
        List<Webtoon> webtoons =  webtoonService.getWebtoons(searchForm.getKeywords(), searchForm.getSearchStr());
        List<WebtoonDto> results = new ArrayList<>();
        for(Webtoon webtoon : webtoons){
            WebtoonDto webtoonDto = new WebtoonDto();
            webtoonDto.setId(webtoon.getId());
            webtoonDto.setTitle(webtoon.getTitle());
            webtoonDto.setSeeAge(webtoon.getSeeAge());
            webtoonDto.setDescription(webtoon.getDescription());
            webtoonDto.setLink(webtoon.getLink());
            webtoonDto.setState(webtoon.getState());
            webtoonDto.setPlatformName(webtoon.getPlatform().getPlatformName());
            //webtoonDto.setWebtoonImageId(webtoon.getWebtoonImage().getId());
            webtoonDto.setWebtoonStateId(webtoon.getWebtoonState().getId());
            results.add(webtoonDto);
        }
        return results;
    }


}

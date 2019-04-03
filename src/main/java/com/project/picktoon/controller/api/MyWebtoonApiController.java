package com.project.picktoon.controller.api;

import com.project.picktoon.domain.MyWebtoon;
import com.project.picktoon.dto.AddMyWebtoonDto;
import com.project.picktoon.dto.MywebtoonDto;
import com.project.picktoon.service.MyWebtoonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/mywebtoon")
@RequiredArgsConstructor
public class MyWebtoonApiController {
    private final MyWebtoonService myWebtoonService;

    //나의 웹툰 목록가져오기
    //TODO 페이징처리
    @GetMapping
    public List<MywebtoonDto> getMyWebtoons(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "ordertype") int ordertype)
    {
        List<MyWebtoon> myWebtoonslist = myWebtoonService.getMyWebtoons(id, ordertype);
        List<MywebtoonDto> myWebtoons = new ArrayList<>();

        for(MyWebtoon m : myWebtoonslist){
            MywebtoonDto mywebtoonDto = new MywebtoonDto();
            mywebtoonDto.setId(m.getId());
            mywebtoonDto.setAlarm(m.getAlarm());
            mywebtoonDto.setUserId(m.getUser().getId());
            mywebtoonDto.setWebtoonId(m.getWebtoon().getId());
       //     mywebtoonDto.setWebtoonImageId(m.getWebtoon().getWebtoonImage().getId());
            mywebtoonDto.setWebtoonTitle(m.getWebtoon().getTitle());

            Date date = (m.getWebtoon().getWebtoonState().getUpdatedDate());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = format.format(date);
            mywebtoonDto.setUpdateDate(dateString);

            mywebtoonDto.setTotalCount(m.getWebtoon().getWebtoonState().getTotalCount());
            myWebtoons.add(mywebtoonDto);
        }
        return myWebtoons;
    }

    //알람 수정하기
    @PutMapping
    public void changeAlarm(@RequestBody Long mywebtoonid){
        myWebtoonService.changeAlarm(mywebtoonid);
    }

    //마이웹툰에서 삭제하기
    @DeleteMapping("/{mywebtoonid}")
    public void deleteMyWebtoon(@PathVariable Long mywebtoonid){
        myWebtoonService.deleteMyWebtoon(mywebtoonid);
    }

    //마이웹툰 추가
    @PostMapping
    public void addMyWebtoon(@RequestBody AddMyWebtoonDto addMyWebtoonDto){
        myWebtoonService.addMyWebtoon(addMyWebtoonDto.getUserId(), addMyWebtoonDto.getWebtoonId());
    }
}

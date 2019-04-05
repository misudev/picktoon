package com.project.picktoon.controller.api;

import com.project.picktoon.domain.MyWebtoon;
import com.project.picktoon.dto.AddMyWebtoonDto;
import com.project.picktoon.dto.MywebtoonDto;
import com.project.picktoon.service.MyWebtoonService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;

    //나의 웹툰 목록가져오기
    //TODO  페이징처리
    //TODO  인증 (로그인 정보)
    @GetMapping
    public List<MywebtoonDto> getMyWebtoons(
            @RequestParam(name = "id") Long userId,
            @RequestParam(name = "ordertype") int ordertype)
    {
        List<MyWebtoon> myWebtoonslist = myWebtoonService.getMyWebtoons(userId, ordertype);
        List<MywebtoonDto> myWebtoons = new ArrayList<>();

        for(MyWebtoon myWebtoon : myWebtoonslist){
            MywebtoonDto mywebtoonDto = modelMapper.map(myWebtoon, MywebtoonDto.class);

            // 최신 업데이트 날짜
            Date date = (myWebtoon.getWebtoon().getWebtoonState().getUpdatedDate());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = format.format(date);
            mywebtoonDto.setUpdateDate(dateString);
            // 웹툰 총 횟수
            mywebtoonDto.setTotalCount(myWebtoon.getWebtoon().getWebtoonState().getTotalCount());
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

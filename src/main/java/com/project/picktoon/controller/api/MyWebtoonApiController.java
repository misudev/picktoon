package com.project.picktoon.controller.api;

import com.project.picktoon.domain.MyWebtoon;
import com.project.picktoon.domain.User;
import com.project.picktoon.dto.AddMyWebtoonDto;
import com.project.picktoon.dto.MywebtoonDto;
import com.project.picktoon.service.MyWebtoonService;
import com.project.picktoon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mywebtoons")
@RequiredArgsConstructor
public class MyWebtoonApiController {
    private final MyWebtoonService myWebtoonService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    //나의 웹툰 목록가져오기
    //TODO  페이징처리
    @GetMapping
    public ResponseEntity<List<MywebtoonDto>> getMyWebtoons(
            @RequestParam(name = "ordertype", required = false) Optional<Integer> ordertype, Principal principal)
    {
        String email = principal.getName();
        User user = userService.getUserByEmail(email);

        List<MyWebtoon> myWebtoonslist = myWebtoonService.getMyWebtoons(user.getId(),ordertype.orElse(1));

        Type listType = new TypeToken<List<MywebtoonDto>>(){}.getType();
        List<MywebtoonDto> myWebtoons = modelMapper.map(myWebtoonslist, listType);

        return new ResponseEntity<List<MywebtoonDto>>(myWebtoons, HttpStatus.OK);
    }

    //알람 수정하기
    @PutMapping
    public ResponseEntity changeAlarm(@RequestBody Long mywebtoonid){
        myWebtoonService.changeAlarm(mywebtoonid);
        return new ResponseEntity(HttpStatus.OK);
    }

    //마이웹툰에서 삭제하기
    @DeleteMapping("/{mywebtoonid}")
    public ResponseEntity deleteMyWebtoon(@PathVariable Long mywebtoonid){
        myWebtoonService.deleteMyWebtoon(mywebtoonid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //마이웹툰 추가
    @PostMapping
    public ResponseEntity addMyWebtoon(@RequestBody AddMyWebtoonDto addMyWebtoonDto, Principal principal){
        String email = principal.getName();
        User user = userService.getUserByEmail(email);
        myWebtoonService.addMyWebtoon(user.getId(), addMyWebtoonDto.getWebtoonId());
        return new ResponseEntity(HttpStatus.OK);
    }
}

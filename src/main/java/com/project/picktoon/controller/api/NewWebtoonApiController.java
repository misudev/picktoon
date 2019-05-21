package com.project.picktoon.controller.api;

import com.project.picktoon.domain.NewWebtoon;
import com.project.picktoon.domain.Webtoon;
import com.project.picktoon.dto.AddNewWebtoonDto;
import com.project.picktoon.dto.NewWebtoonDto;
import com.project.picktoon.service.NewWebtoonService;
import com.project.picktoon.service.WebtoonService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/newwebtoons")
@RequiredArgsConstructor
public class NewWebtoonApiController {
    private final NewWebtoonService newWebtoonService;
    private final WebtoonService webtoonService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<NewWebtoonDto>> getNewWebtoon(){
        List<NewWebtoon> newWebtoonlist = newWebtoonService.getNewWebtoons();
        List<NewWebtoonDto> newWebtoons = new ArrayList<>();

            for(NewWebtoon newWebtoon : newWebtoonlist){
                NewWebtoonDto newWebtoonDto = modelMapper.map(newWebtoon, NewWebtoonDto.class);

                if(!newWebtoon.getWebtoon().getWebtoonImages().isEmpty())
                    newWebtoonDto.setWebtoonImageId(newWebtoon.getWebtoon().getWebtoonImages().get(0).getId());
                newWebtoons.add(newWebtoonDto);

            }
        return new ResponseEntity<>(newWebtoons, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<NewWebtoonDto> addNewWebtoon(@RequestBody AddNewWebtoonDto addNewWebtoonDto){
        NewWebtoonDto newWebtoonDto = new NewWebtoonDto();

        if(webtoonService.getWebtoonByTitle(addNewWebtoonDto.getWebtoonTitle())!=null) {
            Webtoon webtoon = webtoonService.getWebtoonByTitle(addNewWebtoonDto.getWebtoonTitle());
            if(webtoon == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            newWebtoonDto.setWebtoonTitle(addNewWebtoonDto.getWebtoonTitle()); //웹툰제목
            newWebtoonDto.setWebtoonId(webtoon.getId()); //웹툰아이디
            newWebtoonDto.setId(addNewWebtoonDto.getId());//아이디
            newWebtoonDto.setOrdering(addNewWebtoonDto.getOrdering());//ordering
            if (!webtoon.getWebtoonImages().isEmpty())
                newWebtoonDto.setWebtoonImageId(webtoon.getWebtoonImages().get(0).getId()); //웹툰이미지
        }
        //TODO 값이 없을 떄 오류처리 해주기
//        else{
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
        return new ResponseEntity<>(newWebtoonDto, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateNewWebtoon(@RequestBody NewWebtoonDto updateNewWebtoon){
        NewWebtoon newWebtoon = new NewWebtoon();
        newWebtoon.setId(updateNewWebtoon.getId());
        newWebtoon.setOrdering(updateNewWebtoon.getOrdering());
        newWebtoon.setWebtoon(webtoonService.getWebtoonById(updateNewWebtoon.getWebtoonId()));
        newWebtoonService.updateNewWebtoon(newWebtoon);
        return new ResponseEntity(HttpStatus.OK);
    }

}

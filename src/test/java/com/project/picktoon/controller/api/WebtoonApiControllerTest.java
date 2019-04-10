package com.project.picktoon.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.picktoon.domain.Keyword;
import com.project.picktoon.domain.Webtoon;
import com.project.picktoon.domain.WebtoonState;
import com.project.picktoon.dto.KeywordDto;
import com.project.picktoon.dto.WebtoonForm;
import com.project.picktoon.service.*;
import com.project.picktoon.util.SeeAge;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(includeFilters = @ComponentScan.Filter(classes = {EnableWebSecurity.class})) // includeFilters를 포함하지 않아도 Spring Security설정이 잘 사용된다. (?)
public class WebtoonApiControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    WebtoonService webtoonService;
    @MockBean
    KeywordService keywordService;
    @MockBean
    MyWebtoonService myWebtoonService;
    @MockBean
    NewWebtoonService newWebtoonService;
    @MockBean
    PlatformService platformService;
    @MockBean
    UserService userService;
    @MockBean
    WebtoonStateService webtoonStateService;
    @MockBean
    WebtoonImageService webtoonImageService;

    @Before
    public void setUp() throws Exception {
    }

//    @Test
//    public void 웹툰_추가() throws Exception{
//
//        KeywordDto keywordDto1 = KeywordDto.builder().id(1L).keywordType(1).keywordValue("월").build();
//        KeywordDto keywordDto2 = KeywordDto.builder().id(3L).keywordType(3).keywordValue("수").build();
//        List<KeywordDto> keywords = new ArrayList<>();
//        keywords.add(keywordDto1);
//        keywords.add(keywordDto2);
//
//
//        Keyword keyword1 = Keyword.builder().id(1L).keywordType(keywordDto1.getKeywordType())
//                                            .keywordValue(keywordDto1.getKeywordValue()).ordering(1).build();
//        Keyword keyword2 = Keyword.builder().id(3L).keywordType(keywordDto1.getKeywordType())
//                                            .keywordValue(keywordDto2.getKeywordValue()).ordering(2).build();
//
//
//
//        WebtoonForm webtoonForm = WebtoonForm.builder()
//                                            .title("웹툰 제목")
//                                            .link("www.naver.com")
//                                            .description("어쩌구 저쩌구")
//                                            .seeAge(SeeAge.SEEAGE_12)
//                                            .state("연재중")
//                                            .keywords(keywords)
//                                            .platformId(1)
//                                            .subscription(0)
//                                            .webtoonStateId(1L)
//                                            .build();
//        Webtoon webtoon = Webtoon.builder()
//                            .title(webtoonForm.getTitle())
//                            .description(webtoonForm.getDescription())
//                            .link(webtoonForm.getLink())
//                            .seeAge(webtoonForm.getSeeAge())
//                            .state(webtoonForm.getState()).build();
//
//        WebtoonState webtoonState = WebtoonState.builder().updateState(false).webtoon(webtoon).id(1L).totalCount("32화").updatedDate().build();
//
//        Mockito.when(webtoonService.addWebtoon(webtoon)).thenReturn(webtoon);
//        Mockito.when(keywordService.getKeywordById(1L)).thenReturn(keyword1);
//        Mockito.when(keywordService.getKeywordById(3L)).thenReturn(keyword2);
//        Mockito.when(webtoonStateService.getWebtoonStateById(1L)).thenReturn()
//        //when —> 테스트 메소드
//        mockMvc.perform(post("/api/webtoons")
//                        .with(csrf())
//                        .contentType(MediaType.APPLICATION_JSON_UTF8)
//                        .accept(MediaType.APPLICATION_JSON_UTF8)
//                        .content(objectMapper.writeValueAsString(webtoonForm))
//                //).andExpect(status().is(201));
//        )
//                .andDo(print()) // 값을 출력할 수 있다.
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("id").exists()); // id가존재한다.
//        //then —> 테스트 결과값.
////        webtoon.setWebtoonState(webtoonStateService.getWebtoonStateById(webtoonForm.getWebtoonStateId()));
////        webtoon.setPlatform(platformService.getPlatformById(webtoonForm.getPlatformId()));
//    }
}
package com.project.picktoon.controller.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.picktoon.domain.User;
import com.project.picktoon.dto.CheckEmail;
import com.project.picktoon.dto.JoinUser;
import com.project.picktoon.dto.UserDto;
import com.project.picktoon.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {UserApiController.class}, includeFilters = @ComponentScan.Filter(classes = {EnableWebSecurity.class}))
public class UserApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

    @Test
    public void addUser() throws Exception {
        JoinUser joinUser = JoinUser.builder()
                .email("test2@gmail.com")
                .nickName("테스터2")
                .password1("123456")
                .password2("123456")
                .build();

        User user = User.builder()
                .email("test2@gmail.com")
                .nickName("테스터2")
                .passwd(joinUser.getPassword1())
                .build();

        Mockito.when(userService.addUser(user)).thenReturn(user);
        Mockito.when(userService.checkSignUp("test2@gmail.com")).thenReturn(false);

        mockMvc.perform(post("/api/users")
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(joinUser))
        )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("nickName").exists());
    }

    @Test
    @WithMockUser(username = "테스터2", authorities = {"ROLE_USER"})
    public void getUser() throws Exception {

        User user = User.builder()
                .id(3L)
                .email("test2@gmail.com")
                .nickName("테스터2")
                .passwd("123456")
                .build();

        Mockito.when(userService.getUserById(3L)).thenReturn(user);


        mockMvc.perform(get("/api/users/3")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void checkSignUp() throws Exception {

        CheckEmail checkEmail = CheckEmail.builder()
                .email("test1@naver.com")
                .build();

        Mockito.when(userService.checkSignUp("test@naver.com")).thenReturn(false);

    }

//    @PutMapping
//    public ResponseEntity<Result> updateUser(@Valid @RequestBody UserDto updateUser, BindingResult bindingResult){
//        if(updateUser.getId() == null)
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        if(bindingResult.hasErrors())
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//
//        User user = modelMapper.map(updateUser, User.class);
//        // 비밀번호 암호화
//        user.setPasswd(passwordEncoder.encode(updateUser.getPasswd()));
//        // 유저 정보 수정.
//        userService.updateUser(user);
//        Result result = new Result("SUCCESS");
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }

    @Test
    public void updateUser() throws Exception{

        UserDto userDto = UserDto.builder()
                .id(3L)
                .email("test2@gmail.com")
                .nickName("테스터2")
                .passwd("123456")
                .build();

        User user = User.builder()
                .id(3L)
                .email("test2@gmail.com")
                .nickName("테스터2")
                .passwd("123456")
                .build();

        mockMvc.perform(put("/api/users/{id}",3L)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(userDto))
        )
                .andDo(print());



    }



}
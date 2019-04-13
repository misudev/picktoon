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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
                .accept(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void checkSignUp() throws Exception {

        User user = User.builder()
                .id(3L)
                .email("test4@gmail.com")
                .nickName("테스터2")
                .passwd("123456")
                .build();

        CheckEmail checkEmail = CheckEmail.builder()
                .email("test4@gmail.com")
                .build();

        Mockito.when(userService.addUser(user)).thenReturn(user);
        Mockito.when(userService.checkSignUp(user.getEmail())).thenReturn(true);

        mockMvc.perform(post("/api/users/check")
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(checkEmail))
        )
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("result").value("TRUE")) //response에 result가 있으며 값이 TRUE인가?
                .andExpect(status().isOk());
    }

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

    //TODO : findpw 구현 후 테스트

    @Test
    public void updateUser() throws Exception{

        User user = User.builder()
                .id(3L)
                .email("test2@gmail.com")
                .nickName("테스터2")
                .passwd("123456")
                .build();

        UserDto userDto = UserDto.builder()
                .id(user.getId())
                .email("test3@gmail.com")
                .nickName("테스터3")
                .passwd(user.getPasswd())
                .build();

        Mockito.when(userService.addUser(user)).thenReturn(user);
        Mockito.when(userService.getUserById(userDto.getId())).thenReturn(user);

        mockMvc.perform(put("/api/users")
                .with(csrf())
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(userDto))
        )
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("result").value("SUCCESS"))
                .andExpect(status().isOk());
    }
}
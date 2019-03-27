package com.project.picktoon.service;

import com.project.picktoon.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void 유저_아이디로유저찾기(){
        User user = userService.getUserById(1L);
        System.out.println(user);
    }

    @Test
    public void 유저_이메일로유저찾기(){
        User user = userService.getUserByEmail("mimi@naver.com");
        System.out.println(user);
    }

    @Test
    public void 유저_추가하기(){
        User user = new User();

        user.setEmail("333@google.com");
        user.setPasswd("12345asdfg");
        user.setNickName("김모모");

        userService.addUser(user);

        System.out.println(user);
    }

    @Test
    public void 유저_존재회원확인하기(){
        boolean check = userService.checkSignUp("mimi@naver.com");
        System.out.println(check);

    }

    @Test
    public void 유저_비밀번호바꾸기(){
        String newpasswd1 = userService.changePasswd(1L);
        String newpasswd2 = userService.changePasswd(1L);
        String newpasswd3 = userService.changePasswd(1L);
        String newpasswd4 = userService.changePasswd(1L);
        System.out.println(newpasswd1);
        System.out.println(newpasswd2);
        System.out.println(newpasswd3);
        System.out.println(newpasswd4);
    }
}

//
//        @Override
//        @Transactional
//        public User addUser(User user) {
//            return userRepository.save(user);
//        }



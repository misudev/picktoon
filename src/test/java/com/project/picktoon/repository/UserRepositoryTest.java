package com.project.picktoon.repository;

import com.project.picktoon.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void initTest(){

    }

    @Test
    public void getUserByEmail() throws Exception{
        User user = userRepository.getUserByEmail("mimi@naver.com");
        System.out.println(user);
    }

    @Test
    public void existsByEmail() throws Exception{
        Assert.assertEquals(true, userRepository.existsByEmail("test@naver.com"));
    }

//    @Test
//    public void updatePasswd() throws Exception{
//        userRepository.updatePasswd("4444", 1L);
//        User user = userRepository.getOne(1L);
//        System.out.println(user.toString());
//    }
}

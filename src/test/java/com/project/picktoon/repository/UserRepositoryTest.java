package com.project.picktoon.repository;

import com.project.picktoon.domain.User;
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
        User user = userRepository.getUserByEmail("dddd");
        System.out.println(user);
    }

//    @Test
//    public void updatePasswd() throws Exception{
//        userRepository.updatePasswd("4444", 1L);
//        User user = userRepository.getOne(1L);
//        System.out.println(user.toString());
//    }
}

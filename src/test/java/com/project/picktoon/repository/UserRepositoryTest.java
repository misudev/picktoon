package com.project.picktoon.repository;

import com.project.picktoon.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

<<<<<<< HEAD
=======
import static org.junit.Assert.*;
>>>>>>> 1536989a83e316143dc1b17b62f943ad481ee5c5

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;
<<<<<<< HEAD

    @Test
    public void initTest(){

    }

=======
>>>>>>> 1536989a83e316143dc1b17b62f943ad481ee5c5
    @Test
    public void getUserByEmail() throws Exception{
        User user = userRepository.getUserByEmail("dddd");
        System.out.println(user);
    }
<<<<<<< HEAD

//    @Test
//    public void updatePasswd() throws Exception{
//        userRepository.updatePasswd("4444", 1L);
//        User user = userRepository.getOne(1L);
//        System.out.println(user.toString());
//    }
}
=======
}
>>>>>>> 1536989a83e316143dc1b17b62f943ad481ee5c5

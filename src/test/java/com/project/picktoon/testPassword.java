package com.project.picktoon;

import org.junit.Test;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;



public class testPassword {
    @Test
    public void encode()throws Exception{
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String encode = passwordEncoder.encode("1111");
        System.out.println(encode);
    }
}

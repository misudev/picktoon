package com.project.picktoon.controller.api;

import com.project.picktoon.domain.User;
import com.project.picktoon.dto.JoinUser;
import com.project.picktoon.dto.UserDto;
import com.project.picktoon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;

    @GetMapping("/{userId}")
    public UserDto getUser(@PathVariable("userId") Long userId){
        UserDto userDto = new UserDto();
        User user = userService.getUserById(userId);
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setNickName(user.getNickName());
        userDto.setPassword(user.getPasswd());
        userDto.setRoles(user.getRoles());
        return userDto;
    }

//    @GetMapping("/{email}")
//    public User getUser(@PathVariable("email")String email){
//        return userService.getUserByEmail(email);
//    }

    @GetMapping("/check/{email}")
    public boolean checkSignUp(@PathVariable("email")String email){
        return userService.checkSignUp(email);
    }


    @PostMapping
    public boolean addUser(@RequestBody JoinUser joinForm){
        // 비밀번호와 비밀번호 재확인이 일치하지 않으면 false
        if(!joinForm.getPassword1().equals(joinForm.getPassword2()))
            return false;
        User user = new User();
        user.setNickName(joinForm.getNickName());
        user.setEmail(joinForm.getEmail());

        // 비밀번호 암호화
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPasswd(passwordEncoder.encode(joinForm.getPassword1()));

        // 유저 저장.
        userService.addUser(user);

        return true;
    }

    @PutMapping("/findpw/{userId}")
    public void changePasswd(@PathVariable("userId")Long userId){
        String changedPasswd = userService.changePasswd(userId);
        // 바뀐 패스워드를 이메일로 보내준다. (추가 ** )

    }

    @PutMapping
    public boolean updateUser(@RequestBody UserDto updateUser){
        User user = new User();
        user.setId(updateUser.getId());
        user.setNickName(updateUser.getNickName());
        user.setEmail(updateUser.getEmail());
        user.setRoles(updateUser.getRoles());
        // 비밀번호 암호화
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPasswd(passwordEncoder.encode(updateUser.getPassword()));
        // 유저 정보 수정.
        userService.updateUser(user);
        return true;
    }

}

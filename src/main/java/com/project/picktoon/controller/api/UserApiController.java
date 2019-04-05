package com.project.picktoon.controller.api;

import com.project.picktoon.domain.User;
import com.project.picktoon.dto.JoinUser;
import com.project.picktoon.dto.UserDto;
import com.project.picktoon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    @GetMapping("/{userId}")
    public UserDto getUser(@PathVariable("userId") Long userId){
        UserDto userDto = modelMapper.map(userService.getUserById(userId), UserDto.class);
        return userDto;
    }


    @GetMapping("/check/{email}")
    public boolean checkSignUp(@PathVariable("email")String email){
        return userService.checkSignUp(email);
    }


    @PostMapping
    public boolean addUser(@Valid @RequestBody JoinUser joinForm){
        // 이메일 중복일 경우 false
        if(userService.checkSignUp(joinForm.getEmail()))
            return false;

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
        // TODO  바뀐 패스워드를 이메일로 보내준다.

    }

    @PutMapping
    public boolean updateUser(@Valid @RequestBody UserDto updateUser){
        if(updateUser.getId() == null)
            return false;

        User user = modelMapper.map(updateUser, User.class);
        // 비밀번호 암호화
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPasswd(passwordEncoder.encode(updateUser.getPasswd()));
        // 유저 정보 수정.
        userService.updateUser(user);
        return true;
    }

}

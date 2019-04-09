package com.project.picktoon.controller.api;

import com.project.picktoon.domain.User;
import com.project.picktoon.dto.CheckEmail;
import com.project.picktoon.dto.JoinUser;
import com.project.picktoon.dto.Result;
import com.project.picktoon.dto.UserDto;
import com.project.picktoon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") Long userId){
        User user = userService.getUserById(userId);
        if(user == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(user, HttpStatus.OK);

    }


    @PostMapping("/check")
    public ResponseEntity<Result> checkSignUp(@RequestBody CheckEmail checkEmail){
        Result result = new Result();
        // 이미 존재하는 이메일인 경우
        if(userService.checkSignUp(checkEmail.getEmail())){
            result.setResult("TRUE");
        }else{
            result.setResult("FALSE");
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<User> addUser(@Valid @RequestBody JoinUser joinForm, BindingResult bindingResult){
        // 폼을 만족하지 못할 경우 (400 : BAD_REQUEST)
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        // 이메일 중복일 경우 (409 : 요청의 충돌 , CONFILICT)
        if(userService.checkSignUp(joinForm.getEmail()))
            return new ResponseEntity<>(HttpStatus.CONFLICT);

        // 비밀번호와 비밀번호 재확인이 일치하지 않으면 (400 : BAD_REQUEST)
        if(!joinForm.getPassword1().equals(joinForm.getPassword2()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        User user = new User();
        user.setNickName(joinForm.getNickName());
        user.setEmail(joinForm.getEmail());

        // 비밀번호 암호화
        user.setPasswd(passwordEncoder.encode(joinForm.getPassword1()));

        // 유저 저장.
        User joinUser = userService.addUser(user);
        // 저장된 유저 리턴 ( 201 : CREATED)
        return new ResponseEntity<>(joinUser, HttpStatus.CREATED);
    }

    @PutMapping("/findpw/{userId}")
    public void findPasswd(@PathVariable("userId")Long userId){
        String changedPasswd = userService.changePasswd(userId);
        // TODO  바뀐 패스워드를 이메일로 보내준다.

    }

    @PutMapping
    public ResponseEntity<Result> updateUser(@Valid @RequestBody UserDto updateUser, BindingResult bindingResult){
        if(updateUser.getId() == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if(bindingResult.hasErrors())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        User user = modelMapper.map(updateUser, User.class);
        // 비밀번호 암호화
        user.setPasswd(passwordEncoder.encode(updateUser.getPasswd()));
        // 유저 정보 수정.
        userService.updateUser(user);
        Result result = new Result("SUCCESS");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // GET /api/accounts/me --> principal 로 디비조회..
}

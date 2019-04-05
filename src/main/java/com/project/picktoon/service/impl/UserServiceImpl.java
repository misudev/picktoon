package com.project.picktoon.service.impl;

import com.project.picktoon.domain.User;
import com.project.picktoon.repository.RoleRepository;
import com.project.picktoon.repository.UserRepository;
import com.project.picktoon.service.UserService;
import com.project.picktoon.util.CreatePasswd;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    public final UserRepository userRepository;
    public final RoleRepository roleRepository;

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long userId) {
        return userRepository.findUserById(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    @Transactional
    public User addUser(User user) {
        user.addRoles(roleRepository.findByRoleName("USER"));
        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean checkSignUp(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    @Transactional
    public String changePasswd(Long userId) {
        String passwd = CreatePasswd.temporaryPassword(8);
        User user = userRepository.findById(userId).get();
        user.setPasswd(passwd);
        return passwd;
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        User updateuser = userRepository.findById(user.getId()).get();
        updateuser.setNickName(user.getNickName());
        updateuser.setEmail(user.getEmail());
        updateuser.setPasswd(user.getPasswd());

    }
}

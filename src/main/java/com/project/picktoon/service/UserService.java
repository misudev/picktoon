package com.project.picktoon.service;

import com.project.picktoon.domain.User;

public interface UserService {
    public User getUserByEmail(String email);
    public User addUser(User user);
    public boolean checkSignUp(String email);
    public String changePasswd(Long userId);
}

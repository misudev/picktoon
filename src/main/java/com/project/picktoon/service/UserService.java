package com.project.picktoon.service;

import com.project.picktoon.domain.User;

public interface UserService {
    public User getUserById(Long userId);
    public User getUserByEmail(String email);
    public User addUser(User user);
    public boolean checkSignUp(String email);
    public String changePasswd(Long userId);
    public void updateUser(User user);
}

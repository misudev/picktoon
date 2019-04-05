package com.project.picktoon.security;

import com.project.picktoon.domain.Role;
import com.project.picktoon.domain.User;
import com.project.picktoon.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Component
@RequiredArgsConstructor
public class PicktoonUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    // DB에서 유저 정보를 가져오는 메소드 **
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(email);
        if(user == null)
            throw  new UsernameNotFoundException(email + "에 해당하는 사용자가 없습니다.");
        List<GrantedAuthority> authorities = new ArrayList<>();
        Set<Role> roles = user.getRoles();
        for(Role role : roles)
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));

        PicktoonSecurityUser securityUser = new PicktoonSecurityUser(email, user.getPasswd(), authorities);
        securityUser.setId(user.getId());
        securityUser.setNickName(user.getNickName());
        return securityUser;
    }

}

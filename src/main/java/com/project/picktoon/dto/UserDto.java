package com.project.picktoon.dto;

import com.project.picktoon.domain.Role;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class UserDto {
    @NotNull
    private Long id;
    @NotNull
    @Size(min=2, max=45)
    private String nickName;
    @NotNull
    @Size(min=4, max=255)
    private String email;
    @NotNull
    @Size(min=6, max=16)
    private String password;

    private Set<Role> roles;

    public UserDto(){
        roles = new HashSet<>();
    }

}

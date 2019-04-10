package com.project.picktoon.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.picktoon.domain.Role;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    @NotNull
    @Size(min=2, max=45)
    private String nickName;
    @NotNull
    @Size(min=4, max=255)
    private String email;
    @NotNull
    @Size(min=6, max=16)
    private String passwd;

}

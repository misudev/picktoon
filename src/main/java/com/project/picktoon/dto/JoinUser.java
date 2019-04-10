package com.project.picktoon.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JoinUser {
    @NotNull
    @Size(min=2, max=45)
    private String nickName;
    @NotNull
    @Size(min=4, max=255)
    private String email;
    @NotNull
    @Size(min=6, max=16)
    private String password1;
    @NotNull
    @Size(min=6, max=16)
    private String password2;
}

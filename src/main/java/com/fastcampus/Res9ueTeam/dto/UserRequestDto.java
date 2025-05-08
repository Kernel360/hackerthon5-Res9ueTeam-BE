package com.fastcampus.Res9ueTeam.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRequestDto {
    private String email;
    private String password;
    private String nickname;
}

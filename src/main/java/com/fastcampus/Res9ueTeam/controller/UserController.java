package com.fastcampus.Res9ueTeam.controller;

import com.fastcampus.Res9ueTeam.dto.LoginResponseDto;
import com.fastcampus.Res9ueTeam.dto.UserRequestDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/nickname")
    public String getUserNickname(HttpSession session) {
        Object loginUserNickname = session.getAttribute("LOGIN_USER_NICKNAME");
        return loginUserNickname.toString();
    }

//    @PostMapping("/create")
//    public ResponseEntity<LoginResponseDto> createUser(
//            @RequestBody UserRequestDto userRequestDto, HttpSession session
//    ) {
//
//    }
}

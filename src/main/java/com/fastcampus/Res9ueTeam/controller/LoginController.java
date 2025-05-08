package com.fastcampus.Res9ueTeam.controller;

import com.fastcampus.Res9ueTeam.dto.LoginRequestDto;
import com.fastcampus.Res9ueTeam.dto.LoginResponseDto;
import com.fastcampus.Res9ueTeam.service.LoginService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(
            @RequestBody LoginRequestDto loginRequestDto, HttpSession session
    ) {
        LoginResponseDto loginResponseDto = loginService.login(loginRequestDto);
        session.setAttribute("LOGIN_USER_ID", loginResponseDto.getId());
        session.setAttribute("LOGIN_USER_NICKNAME", loginResponseDto.getNickname());

        Object loginUserId = session.getAttribute("LOGIN_USER_ID");
        Object loginUserNickname = session.getAttribute("LOGIN_USER_NICKNAME");
        log.info("세션 로그인 사용자 ID: {}", loginUserId);
        log.info("세션 로그인 사용자 닉네임: {}", loginUserNickname);

        LoginResponseDto loginDto = new LoginResponseDto(loginResponseDto.getId(), loginResponseDto.getNickname(), loginUserId.toString());

        return ResponseEntity.ok().body(loginDto);
    }

    @PostMapping("/logout")
    public ResponseEntity logout(HttpSession session) {
        session.invalidate(); // 세션 무효화 (로그아웃)
        return ResponseEntity.ok("로그아웃 성공");
    }
}
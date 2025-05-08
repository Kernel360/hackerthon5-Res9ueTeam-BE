package com.fastcampus.Res9ueTeam.controller;

import com.fastcampus.Res9ueTeam.dto.UserRequestDto;
import com.fastcampus.Res9ueTeam.dto.UserResponseDto;
import com.fastcampus.Res9ueTeam.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/nickname")
    public ResponseEntity<String> getUserNickname(HttpSession session) {
        Object loginUserNickname = session.getAttribute("LOGIN_USER_NICKNAME");

        if (loginUserNickname == null) {
            return ResponseEntity.status(401).body("로그인이 필요합니다.");
        }

        return ResponseEntity.ok(loginUserNickname.toString());
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> createUser(
        @RequestBody @Valid UserRequestDto userRequestDto
    ) {
        UserResponseDto saved = userService.save(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}

package com.fastcampus.Res9ueTeam.service;

import com.fastcampus.Res9ueTeam.dto.LoginRequestDto;
import com.fastcampus.Res9ueTeam.dto.LoginResponseDto;
import com.fastcampus.Res9ueTeam.repository.UserRepository;
import lombok.AllArgsConstructor;
import com.fastcampus.Res9ueTeam.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        User user = userRepository.findByEmail(loginRequestDto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("비밀번호 혹은 이메일이 맞지 않습니다."));

        if (!passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("비밀번호 혹은 이메일이 맞지 않습니다.");
        }

        return new LoginResponseDto(user.getId(), user.getNickname());
    }
}

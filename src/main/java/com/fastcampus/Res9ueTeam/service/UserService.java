package com.fastcampus.Res9ueTeam.service;

import com.fastcampus.Res9ueTeam.dto.UserRequestDto;
import com.fastcampus.Res9ueTeam.dto.UserResponseDto;
import com.fastcampus.Res9ueTeam.entity.User;
import com.fastcampus.Res9ueTeam.global.exception.CustomException;
import com.fastcampus.Res9ueTeam.global.exception.ErrorCode;
import com.fastcampus.Res9ueTeam.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserResponseDto save(UserRequestDto userRequestDto) {
        if (userRepository.existsByEmail(userRequestDto.getEmail())) {
            throw new CustomException(ErrorCode.DUPLICATE_EMAIL_EXCEPTION);
        }

        String encodedPassword = passwordEncoder.encode(userRequestDto.getPassword());

        User user = User.builder()
                .email(userRequestDto.getEmail())
                .password(encodedPassword)
                .nickname(userRequestDto.getNickname())
                .build();
        User userSaved = userRepository.save(user);
        return UserResponseDto.builder()
                .id(userSaved.getId())
                .build();
    }
}

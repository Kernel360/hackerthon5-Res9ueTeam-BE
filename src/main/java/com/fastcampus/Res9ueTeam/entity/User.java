package com.fastcampus.Res9ueTeam.entity;

import com.fastcampus.Res9ueTeam.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
@Entity
@Table(name = "`user`")
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    private String email;

    @NotEmpty
    @Size(min = 8)
    private String password;

    @NotEmpty
    private String nickname;
}

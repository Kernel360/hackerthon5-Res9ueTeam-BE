package com.fastcampus.Res9ueTeam.entity;

import com.fastcampus.Res9ueTeam.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class MoneyRecord extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    private Integer amount;

    private LocalDate recordDate;
}